package naumen.java.shelter.services;

import naumen.java.shelter.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    protected List<Animal> animals;

    public AnimalService(){
        animals = new ArrayList<>();
        animals.add(new Animal("Кокос", 1L));
        animals.add(new Animal("Персик", 2L));
        animals.add(new Animal("Компот", 3L));
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public Animal getAnimalId(Long id)
    {
        List<Animal> found =
            animals.stream().filter(animal -> animal.getId() == id).collect(Collectors.toList());
            return found.size() == 0 ? null : found.stream().findFirst().get();
    }
}
