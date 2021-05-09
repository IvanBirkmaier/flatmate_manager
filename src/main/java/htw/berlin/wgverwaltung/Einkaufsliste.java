package htw.berlin.wgverwaltung;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Einkaufsliste {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Einkaufsliste() {}

    public Einkaufsliste(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
