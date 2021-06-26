package htw.berlin.wgverwaltung.service;

import htw.berlin.wgverwaltung.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PutzplanRepository putzplanRepository;

    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private FinanzRepository finanzRepository;

    public List<ProduktEntity> findAll(String userEmail) {
        var iterator = produktRepository.findAll();
        var products = new ArrayList<ProduktEntity>();
        var completed = new ArrayList<ProduktEntity>();
        var uncompleted = new ArrayList<ProduktEntity>();
        for (ProduktEntity p : iterator) {
            if(p.getOwner()!=null && p.getOwner().equals(userEmail)){
                if(p.getCompleted() == false){
                        products.add(0,p);
                }else if(p.getCompleted() == true){
                  products.add(p);
                }
            }
        }
        Collections.reverse(products);
        return products;
    }


    public void deleteAll(String userEmail){
        var iterator = produktRepository.findAll();
        for (ProduktEntity p : iterator) {
            if(p.getOwner()!=null && p.getOwner().equals(userEmail)){ produktRepository.delete(p);}
        }
    }

    public void deleteProductById(Long productId){
        produktRepository.deleteById(productId);
    }

    public void completed(Long productId){
      produktRepository.findById(productId).get().setCompleted(true);
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

    //Finanzfunktionen
    public List<FinanzEntity>findeAlleFinanzen(){
        var iterator = finanzRepository.findAll();
        var finanzen = new ArrayList<FinanzEntity>();
        iterator.forEach(finanzen::add);
        return finanzen;
    }

    public void deleteFinance(FinanzEntity f){finanzRepository.delete(f);}

}
