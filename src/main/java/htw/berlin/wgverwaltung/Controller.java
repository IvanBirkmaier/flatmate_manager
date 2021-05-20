package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {


private Service service = new Service();

@GetMapping("/createputzplan")
public String putzplanForm(Model model){
    model.addAttribute("putzplan", new Putzplan());
    return "putzplancreation";
}
@PostMapping ("/createputzplan")
    public String putzplanSubmit(@ModelAttribute Putzplan putzplan, Model model){
    service.savePutzplan(putzplan);
    model.addAttribute("putzplan", putzplan);
    return "putzplan result";
}
    @GetMapping("/createeinkaufsliste")
    public String einkaufslisteForm(Model model){
        model.addAttribute("einkaufsliste", new Einkaufsliste());
        return "einkaufslistecreation";
    }
    @PostMapping ("/createeinkaufslisten")
    public String einkaufslisteSubmit(@ModelAttribute Einkaufsliste einkaufsliste, Model model){
        service.saveEinkaufsliste(einkaufsliste);
        model.addAttribute("einkaufsliste", einkaufsliste);
        return "einkaufsliste result";
    }
@PostMapping("/kauf")
    public String einkaufslisteErstellen(@ModelAttribute Einkaufsliste einkaufsliste, Model model){
    service.saveEinkaufsliste(einkaufsliste);
    model.addAttribute("einkaufsliste", einkaufsliste);
    return "einkaufsliste";
}

@GetMapping("/JO")
    public String jojotest(){
    return "JO";
}
}



