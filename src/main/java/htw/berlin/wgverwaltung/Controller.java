package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

@Autowired
private Service service = new Service();

@GetMapping("/create")
public String einkaufslisteInput(Model model){
    model.addAttribute("einkaufsliste", new Einkaufsliste());
    return "einkaufslisteerstellen";
}

   @PostMapping("/createeinkaufslisten")
    public String einkaufslisteSubmit(@ModelAttribute Einkaufsliste einkaufsliste, Model model){
        service.saveEinkaufsliste(einkaufsliste);
        model.addAttribute("einkaufsliste", einkaufsliste);
        return "einkaufsliste";
    }

}





