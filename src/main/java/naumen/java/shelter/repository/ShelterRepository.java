package naumen.java.shelter.repository;

import naumen.java.shelter.model.Shelter;
import naumen.java.shelter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ShelterRepository extends CrudRepository<Shelter, Long> {
}
