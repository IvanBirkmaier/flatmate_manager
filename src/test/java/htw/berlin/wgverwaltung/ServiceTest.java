package htw.berlin.wgverwaltung;

import htw.berlin.wgverwaltung.persistence.PinnwandRepository;
import htw.berlin.wgverwaltung.persistence.ProduktEntity;
import htw.berlin.wgverwaltung.persistence.ProduktRepository;
import htw.berlin.wgverwaltung.service.Service;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;

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

   /* @Test
    @DisplayName("Soll alle Produkte eines Users löschen.")
    void testDeleteAllProducts(){
        var p1 = new ProduktEntity("OwnerProduct");
        p1.setOwner("Owner");
        var p2 = new ProduktEntity("OwnerProduct2");
        p2.setOwner("Owner");


        List<ProduktEntity> productList = service.findAll("Owner");
        service.deleteAll("Owner");
        assertThat(productList.isEmpty()==false);
    }
*/
   /* @Test
    @DisplayName("Soll ein Produkt mit einer bestimmten ID löschen.")
    void testDeleteProductById(){
        var p1 = new ProduktEntity("product1");
        p1.setOwner("Owner");
        p1.setProductId(123L);
        var p2 = new ProduktEntity("product2");
        p2.setOwner("Owner");
        p2.setProductId(456L);



        List<ProduktEntity> productList = service.findAll("Owner");
        for (int i = 0, )
        productList.add(service.findAll("Owner"));
        assertThat(productList.isEmpty());
*/

    @Test
}
