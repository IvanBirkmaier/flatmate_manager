package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Service {
    @Autowired
    private PutzplaeneRepository putzplaeneRepository;
    @Autowired
    private EinkaufslisteRepository einkaufslisteRepository;

    public List<Putzplaene> findeAllePutzplaene(){
        var interator :interable<Putzplaene> =
    }
}
