package htw.berlin.wgverwaltung.web;

import htw.berlin.wgverwaltung.persistence.ProduktEntity;
import htw.berlin.wgverwaltung.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

@Autowired
private Service service = new Service();



@GetMapping("/startseite")
    public String startseite(@AuthenticationPrincipal OidcUser user, Model model){
    String email = user.getEmail();
    model.addAttribute("email", email);
    model.addAttribute("firstName", user.getGivenName());
    model.addAttribute("lastName", user.getFamilyName());
    model.addAttribute("produkt", new ProduktEntity());
    return "startseite";
}

@GetMapping("/createProdukt")
    public String createProdukt( @AuthenticationPrincipal OidcUser user, Model model){
    return "produkterstellen";
}

@GetMapping("/products")
public List products(@AuthenticationPrincipal OidcUser user, Model model){
    List<ProduktEntity> products = service.findeAlleOffenenProdukte();
    model.addAttribute("products", products);
    return products;
}



@PostMapping("/saveProdukt")
    public String saveProdukt(@AuthenticationPrincipal OidcUser user,@ModelAttribute ProduktEntity produktEntity, Model model){
    service.saveProdukt(produktEntity);
    model.addAttribute("produkt", produktEntity);
    return "startseite";
}

}





