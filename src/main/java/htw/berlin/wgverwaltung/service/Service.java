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

    public List<ProduktEntity> findAll(String userEmail) {
        System.out.println("1");
        var iterator = produktRepository.findAll();
        var products = new ArrayList<ProduktEntity>();
        for (ProduktEntity p : iterator) {
            if(p.getOwner()!=null && p.getOwner().equals(userEmail)){ products.add(p);}
        }
        return products;
    }

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

    public ProduktEntity saveProdukt(ProduktEntity produktEntity){
        return produktRepository.save(produktEntity);
    }


}
