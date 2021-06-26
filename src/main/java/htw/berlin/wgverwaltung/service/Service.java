package htw.berlin.wgverwaltung.service;

import htw.berlin.wgverwaltung.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PutzplanRepository putzplanRepository;


    @Autowired
    private PinWandRepository pinWandRepository;

    @Autowired
    private ProduktRepository produktRepository;




    //Produkt

    @Autowired
    private FinanzRepository finanzRepository;


    public List<ProduktEntity> findAll(String userEmail) {
        var iterator = produktRepository.findAll();
        var products = new ArrayList<ProduktEntity>();
        for (ProduktEntity p : iterator) {
            if(p.getOwner()!=null && p.getOwner().equals(userEmail)){
                if(p.getCompleted() == false){
                        products.add(p);
                }else if(p.getCompleted() == true){
                  products.add(0,p);
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
    var p = produktRepository.findById(productId).get();
    p.setCompleted(true);
    produktRepository.save(p);
    }

    public ProduktEntity saveProdukt(ProduktEntity produktEntity) {
        return produktRepository.save(produktEntity);
    }

//PinWall
public List<PinWandEntity> findAllpinWall(String userEmail) {
    var iterator = pinWandRepository.findAll();
    var pinwall = new ArrayList<PinWandEntity>();
    for (PinWandEntity p : iterator) {
        if (p.getOwner() != null && p.getOwner().equals(userEmail)) {
            pinwall.add(p);
        }
    }
    return pinwall;
}

    public void deletePinWallById(Long pinWallId){
        pinWandRepository.deleteById(pinWallId);
    }

    public PinWandEntity savePinWall(PinWandEntity pinWandEntity) {
        return pinWandRepository.save(pinWandEntity);
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
