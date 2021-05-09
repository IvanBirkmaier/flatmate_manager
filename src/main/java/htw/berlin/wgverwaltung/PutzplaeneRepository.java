package htw.berlin.wgverwaltung;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PutzplaeneRepository extends CrudRepository<Putzplan, Long> {
}
