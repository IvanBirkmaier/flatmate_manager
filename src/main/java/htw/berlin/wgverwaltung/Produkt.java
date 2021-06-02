package htw.berlin.wgverwaltung;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID", nullable = false)
    private Long productId;
    @Column(name="PRODUCTNAME", nullable = false)
    private String productname;
    @Column(name="COMPLETED")
    private Boolean completed;

    protected Produkt(){
    this.completed = false;
    }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

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

