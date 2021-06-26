package htw.berlin.wgverwaltung.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinnwandRepository extends CrudRepository<PinnwandEntity, Long> {
}
