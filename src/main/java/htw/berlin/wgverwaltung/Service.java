package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Service {

    @Autowired
    private PutzplaeneRepository putzplaeneRepository;
    @Autowired
    private EinkaufslisteRepository einkaufslisteRepository;

    public List<Putzplan> findeAllePutzplaene(){
        var iterator = putzplaeneRepository.findAll();
        var putzplaene = new ArrayList<Putzplan>();
        iterator.forEach(putzplaene::add);
        return putzplaene;
    }

    public List<Einkaufsliste> findeAlleEinkaufslisten(){
        var iterator = einkaufslisteRepository.findAll();
        var einkaufslisten = new ArrayList<Einkaufsliste>();
        iterator.forEach(einkaufslisten::add);
        return einkaufslisten;
    }

    public Long countAllEinkaufslisten(){
       return einkaufslisteRepository.count();
    }

    public Long countAllPutzplaene(){
        return putzplaeneRepository.count();
    }

    public void deleteByIdPutzplane(Long putzplanId){
        putzplaeneRepository.deleteById(putzplanId);
    }
    public void deleteByIdEinkaufsliste(Long einkaufslisteId){
        putzplaeneRepository.deleteById(einkaufslisteId);
    }

    public void savePutzplan(Putzplan putzplan){
        putzplaeneRepository.save(putzplan);
    }
    public void saveEinkaufsliste(Einkaufsliste einkaufsliste){
        einkaufslisteRepository.save(einkaufsliste);
    }

}
