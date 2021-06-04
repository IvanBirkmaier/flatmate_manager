package htw.berlin.wgverwaltung;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PutzplanRepository putzplanRepository;

    @Autowired
    private ProduktRepository produktRepository;


//Produkt Funktionen
    public List<Produkt> findeAlleProdukte(){
        var iterator = produktRepository.findAll();
        var produkte = new ArrayList<Produkt>();
        iterator.forEach(produkte::add);
        return produkte;
    }
    public List<Produkt> findeAlleOffenenProdukte(){
        var iterator = produktRepository.findAll();
        var produkte = new ArrayList<Produkt>();
        iterator.forEach(produkte::add);

        for(Produkt p : produkte){
            if(p.getCompleted()){
                produkte.remove(p);
            }
        }
        return produkte;
    }

    public void deleteProductById(Long productId){
        produktRepository.deleteById(productId);
    }
    public void deleteProduct(Produkt p){
        produktRepository.delete(p);
    }

//Putzplan Funktionen
    public List<Putzplan> findeAllePutzplaene(){
        var iterator = putzplanRepository.findAll();
        var putzplaene = new ArrayList<Putzplan>();
        iterator.forEach(putzplaene::add);
        return putzplaene;
    }

    public Long countAllPutzplaene(){
        return putzplanRepository.count();
    }

    public void deleteByIdPutzplane(Long putzplanId){
        putzplanRepository.deleteById(putzplanId);
    }


    public void savePutzplan(Putzplan putzplan){
        putzplanRepository.save(putzplan);
    }

    public void saveProdukt(Produkt produkt){produktRepository.save(produkt);}


}
