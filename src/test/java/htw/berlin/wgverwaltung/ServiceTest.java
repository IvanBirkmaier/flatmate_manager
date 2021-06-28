package htw.berlin.wgverwaltung;

import htw.berlin.wgverwaltung.persistence.PinnwandEntity;
import htw.berlin.wgverwaltung.persistence.PinnwandRepository;
import htw.berlin.wgverwaltung.persistence.ProduktEntity;
import htw.berlin.wgverwaltung.persistence.ProduktRepository;
import htw.berlin.wgverwaltung.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private Service service;

    @MockBean
    private ProduktRepository produktRepo;

    @MockBean
    private PinnwandRepository pinnwandRepo;

    @Test
    @DisplayName("Soll alle Produkte eines Users finden")
    void testFindAllProducts(){

        var p1 = new ProduktEntity("OwnerProduct");
        p1.setOwner("Owner");
        var p2 = new ProduktEntity("notOwnerProduct");
        p2.setOwner("notTheOwner");

        doReturn(List.of(p1, p2)).when(produktRepo).findAll();

        List<ProduktEntity> ownerProducts = service.findAll("Owner");

        Assertions.assertSame(ownerProducts.size(),1,"Die Anzahl der Produkte");
        Assertions.assertSame(ownerProducts.get(0).getProductname(),"OwnerProduct", "Das Produkt des Users");

    }
    @Test
    @DisplayName("Soll alle Pinnwandeinträge eines Users anzeigen/filtern")
   void testFindAllPinboard(){
        String post = "Text to Show on the Board";
        String owner = "Owner";
        var pb1 = new PinnwandEntity();
        pb1.setOwner(owner);
        pb1.setPost(post);

        var pb2 = new PinnwandEntity();
        pb2.setOwner("NotOwner");
        pb2.setPost("Lorem Ipsum");

        doReturn(List.of(pb1,pb2)).when(pinnwandRepo).findAll();

        List<PinnwandEntity> ownerPosts = service.findAllpinWall(owner);

        Assertions.assertSame(ownerPosts.size(), 1, "Anzahl der Owner Posts");
        Assertions.assertSame(ownerPosts.get(0).getPost(), post, "Owner Post");

   }

}
