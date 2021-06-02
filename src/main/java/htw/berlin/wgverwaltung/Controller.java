package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {
@Autowired
private Service service = new Service();

@GetMapping("/home")
    public String startseite(Model model){
    return "startseite";
}



}





