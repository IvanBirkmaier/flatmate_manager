package htw.berlin.wgverwaltung.service;

import htw.berlin.wgverwaltung.persistence.ProduktEntity;
import htw.berlin.wgverwaltung.persistence.ProduktRepository;
import htw.berlin.wgverwaltung.persistence.PutzplanEntity;
import htw.berlin.wgverwaltung.persistence.PutzplanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PutzplanRepository putzplanRepository;

    @Autowired
    private ProduktRepository produktRepository;


//Produkt Funktionen
    public List<ProduktEntity> findeAlleProdukte(){
        var iterator = produktRepository.findAll();
        var produkte = new ArrayList<ProduktEntity>();
        iterator.forEach(produkte::add);
        return produkte;
    }
    public List<ProduktEntity> findeAlleOffenenProdukte(){
        var iterator = produktRepository.findAll();
        var produkte = new ArrayList<ProduktEntity>();
        iterator.forEach(produkte::add);

        for(ProduktEntity p : produkte){
            if(p.getCompleted()){
                produkte.remove(p);
            }
        }
        return produkte;
    }

    public void deleteProductById(Long productId){
        produktRepository.deleteById(productId);
    }
    public void deleteProduct(ProduktEntity p){
        produktRepository.delete(p);
    }

//Putzplan Funktionen
    public List<PutzplanEntity> findeAllePutzplaene(){
        var iterator = putzplanRepository.findAll();
        var putzplaene = new ArrayList<PutzplanEntity>();
        iterator.forEach(putzplaene::add);
        return putzplaene;
    }

    public Long countAllPutzplaene(){
        return putzplanRepository.count();
    }

    public void deleteByIdPutzplane(Long putzplanId){
        putzplanRepository.deleteById(putzplanId);
    }


    public void savePutzplan(PutzplanEntity putzplanEntity){
        putzplanRepository.save(putzplanEntity);
    }

    public void saveProdukt(ProduktEntity produktEntity){produktRepository.save(produktEntity);}


}
