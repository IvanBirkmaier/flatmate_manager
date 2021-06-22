package htw.berlin.wgverwaltung.persistence;

import htw.berlin.wgverwaltung.persistence.ProduktEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends CrudRepository<ProduktEntity, Long> {
}
