package htw.berlin.wgverwaltung.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends CrudRepository<ProduktEntity, Long> {
}
