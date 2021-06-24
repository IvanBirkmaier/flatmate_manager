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
        public void delete(@PathVariable("id") String id){
            Long productId = Long.parseLong(id);
            service.deleteProductById(productId);
        }







}
