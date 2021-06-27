package htw.berlin.wgverwaltung.persistence;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;

@Entity
@Table(name="invoices")
public class FinanzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financeId", nullable = false)
    private Long financeId;
    @Column(name = "value", nullable = false)
    private float value;
    @Column(name = "greator", nullable = false)
    private String greator;

    //private ArrayList<String> owners = new ArrayList<String>();

    public FinanzEntity() {
    }

    public FinanzEntity(String greator, float value, ArrayList owners) {
        this.greator = greator;
        this.value = value;
        //this.owners = owners;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getGreator() {
        return greator;
    }

    public void setGreator(String owner) {
        this.greator = owner;
    }

   /**public ArrayList getOwners() {
        return owners;
    }

    public void setOwners(ArrayList owners) {
        this.owners = owners;
    }

    public float pricePerMemberPerNewInvoice(float value, List owners) {
        float divide = Float.parseFloat(String.valueOf(owners.getSize()) + 1);
        float pricePerMember = value / divide;
        return pricePerMember;
    }*/






}

