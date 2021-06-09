package htw.berlin.wgverwaltung;

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

    @GetMapping("/home")
    public String getCurrentUser(@AuthenticationPrincipal OidcUser user, Model model) {
        String email = user.getEmail();

        model.addAttribute("email", email);
        //model.addAttribute("lastAccess", usersLastAccess.get(email));
        model.addAttribute("firstName", user.getGivenName());
        model.addAttribute("lastName", user.getFamilyName());

       // usersLastAccess.put(email, LocalDateTime.now());

        return "home";
    }

@GetMapping("/startseite")
    public String startseite(Model model){
    List<Produkt> products = service.findeAlleOffenenProdukte();
    model.addAttribute("products", products);
    return "startseite";
}

@GetMapping("/createProdukt")
    public String createProdukt( Model model){
    model.addAttribute("produkt", new Produkt());
    return "produkterstellen";
}

@PostMapping("/saveProdukt")
    public String saveProdukt(@ModelAttribute Produkt produkt, Model model){
    service.saveProdukt(produkt);
    model.addAttribute("produkt", produkt);
    return "startseite";
}

}





