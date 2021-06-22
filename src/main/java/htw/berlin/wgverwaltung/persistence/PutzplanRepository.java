package htw.berlin.wgverwaltung.persistence;

import htw.berlin.wgverwaltung.persistence.PutzplanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PutzplanRepository extends CrudRepository<PutzplanEntity, Long> {
}
