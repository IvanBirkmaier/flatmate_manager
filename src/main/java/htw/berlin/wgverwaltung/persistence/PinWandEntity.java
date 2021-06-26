package htw.berlin.wgverwaltung.persistence;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import javax.persistence.*;


@Entity
@Table(name="pinwall")
public class PinWandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pinwall_id", nullable = false)
    private Long pinwallId;
    @Column(name="post", nullable = false)
    private String post;
    private String owner;

    public PinWandEntity() {}

    public Long getPinwallId() {
        return pinwallId;
    }

    public void setPinwallId(Long pinwallId) {
        this.pinwallId = pinwallId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
