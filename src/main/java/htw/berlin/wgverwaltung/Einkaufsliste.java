package htw.berlin.wgverwaltung;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class Einkaufsliste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private List products;
    private Boolean completed;

    protected Einkaufsliste() {
    }

    public Einkaufsliste(String name) {
        this.name = name;
        this.completed = false;
    }

    public void setProducts(String productname){
        products.add(productname);
    }

    public List getProducts() {
        return products;
    }

    public long getId() {
        return id;
    }

    //Notwendig trotz Generierung?
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


}