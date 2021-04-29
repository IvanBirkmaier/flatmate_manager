package htw.berlin.wgverwaltung;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

    @RequestMapping("/helloWorld")
    public String index() {
        return "Greetings from Ivan!";
    }

}