package htw.berlin.wgverwaltung;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PutzplanRepository extends CrudRepository<Putzplan, Long> {
}
