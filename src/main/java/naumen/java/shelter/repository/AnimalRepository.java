package naumen.java.shelter.repository;

import naumen.java.shelter.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
