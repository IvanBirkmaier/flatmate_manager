package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
@Autowired
private Service service = new Service();

@GetMapping("/home")
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





