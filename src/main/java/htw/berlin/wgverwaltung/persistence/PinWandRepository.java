package htw.berlin.wgverwaltung.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinWandRepository extends CrudRepository<PinWandEntity, Long> {
}
