package htw.berlin.wgverwaltung.web;

import htw.berlin.wgverwaltung.persistence.ProduktEntity;
import htw.berlin.wgverwaltung.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtikelController {

    @Autowired
    private Service service = new Service();


    @GetMapping("/findartikel")
    public List<ProduktEntity> alleArtikel(@AuthenticationPrincipal OidcUser user) {
        return service.findAll(user.getEmail());
    }


    @PostMapping("/artikelhinzufuegen")
    public ProduktEntity createProduct(@AuthenticationPrincipal OidcUser user, @RequestBody ProduktEntity produkt) {
        produkt.setOwner(user.getEmail());
        return service.saveProdukt(produkt);
    }

    @PostMapping("/alleartikellöschen")
    public void deleteAllProducts(@AuthenticationPrincipal OidcUser user){
        service.deleteAll(user.getEmail());
    }


        @DeleteMapping("/artikelloeschen/{id}")
        public void delete(@PathVariable String id){
            Long productId = Long.parseLong(id);
            service.deleteProductById(productId);
        }

        @PostMapping("/artikelgrau/{id}/{completed}")
         public void completed(@PathVariable String id, @PathVariable String completed){
            Long productId = Long.parseLong(id);
            boolean complete = false;
        if(completed.equals("true")){
            complete =true;
        }
            service.completed(productId, complete);
        }





}
