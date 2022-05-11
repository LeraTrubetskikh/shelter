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

    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository =animalRepository;
    }

    public Animal getAnimalById(Long id)
    {
        var allAnimals = animalRepository.findAll();
        var listAnimals = new ArrayList<Animal>();
        allAnimals.forEach(animal -> {if (animal.getId() == id) listAnimals.add(animal);});
        return listAnimals.size() == 0 ? null : listAnimals.stream().findFirst().get();
    }

    public void saveAnimal(Animal animal)
    {
        animalRepository.save(animal);
    }

    public ArrayList<Animal> getAnimals()
    {
        var allAnimals= animalRepository.findAll();
        var listAnimals = new ArrayList<Animal>();
        allAnimals.forEach(listAnimals::add);
        return listAnimals;
    }
}
