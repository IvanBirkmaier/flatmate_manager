package htw.berlin.wgverwaltung;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Einkaufsliste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productname;
    private Boolean completed;

    protected Einkaufsliste() {
    }

    public Einkaufsliste(String productname) {
        this.productname = productname;
        this.completed = false;
    }

    public long getId() {
        return id;
    }

    //Notwendig trotz Generierung?
    public void setId(long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}