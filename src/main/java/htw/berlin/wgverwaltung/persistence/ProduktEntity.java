package htw.berlin.wgverwaltung.persistence;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import javax.persistence.*;


@Entity
@Table(name="product")
public class ProduktEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id", nullable = false)
    private Long productId;
    @Column(name="productname", nullable = false)
    private String productname;
    @Column(name="completed", nullable = false)
    private Boolean completed = false;
    @Column(name="owner", nullable = false)
    private String owner;


    public ProduktEntity(String productname){
        this.productname = productname;
    }
    public ProduktEntity(){}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

