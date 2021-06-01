package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@org.springframework.stereotype.Controller
public class Controller {

@Autowired
private Service service = new Service();


@GetMapping("/home")
public String mainbord(){
    return "mainbord";
}

@GetMapping("/create")
public String einkaufslisteInput(Model model){
    model.addAttribute("einkaufsliste", new Einkaufsliste());
    return "einkaufslisteerstellen";
}

   @PostMapping("/createeinkaufslisten")
    public void einkaufslisteSubmit(@ModelAttribute Einkaufsliste einkaufsliste, Model model){
        service.saveEinkaufsliste(einkaufsliste);
        model.addAttribute("einkaufsliste", einkaufsliste);
    }


    public String showProducts(@ModelAttribute Einkaufsliste einkaufsliste, Model model){
    List products = einkaufsliste.getProducts();
    model.addAttribute("einkaufsliste", einkaufsliste);

    return "JO";
    }


}





