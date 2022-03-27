package naumen.java.shelter.services;

import naumen.java.shelter.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    protected List<Animal> animals;

    public AnimalService(){
        animals = new ArrayList<>();
        animals.add(new Animal("Кокос"));
        animals.add(new Animal("Персик"));
        animals.add(new Animal("Компот"));
    }

    public List<Animal> getAnimals(){
        return animals;
    }
}
