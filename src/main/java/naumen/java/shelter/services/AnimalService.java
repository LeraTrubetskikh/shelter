package naumen.java.shelter.services;

import naumen.java.shelter.model.Animal;
import naumen.java.shelter.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;
    protected List<Animal> animals;

    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository =animalRepository;
//        animals = new ArrayList<>();
//        animals.add(new Animal("Кокос", 1L));
//        animals.add(new Animal("Персик", 2L));
//        animals.add(new Animal("Компот", 3L));
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public Animal getAnimalId(Long id)
    {
//        List<Animal> found =
//            animals.stream().filter(animal -> animal.getId() == id).collect(Collectors.toList());
//            return found.size() == 0 ? null : found.stream().findFirst().get();

        var allAnimals = animalRepository.findAll();
        var listAnimals = new ArrayList<Animal>();
        allAnimals.forEach(animal -> {if (animal.getId() == id) listAnimals.add(animal);});

        return listAnimals.size() == 0 ? null : listAnimals.stream().findFirst().get();

    }

    public void saveAnimal(String name)
    {
        Animal animal = new Animal(name);
        animalRepository.save(animal);
    }

    public ArrayList<Animal> getAnimalss()
    {
        var allAnimals= animalRepository.findAll();
        var listAnimals = new ArrayList<Animal>();
        allAnimals.forEach(listAnimals::add);
        return listAnimals;
    }
}
