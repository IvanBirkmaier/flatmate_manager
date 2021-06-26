package htw.berlin.wgverwaltung.persistence;


import javax.persistence.*;

@Entity
@Table
public class FinanzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financeId", nullable = false)
    private Long financeId;
    @Column(name = "value", nullable = false)
    private float value;
    @Column(name = "owner", nullable = false)
    private String owner;

    protected FinanzEntity(){}

    public FinanzEntity(float value, String owner){
        this.value=value;
        this.owner=owner;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
