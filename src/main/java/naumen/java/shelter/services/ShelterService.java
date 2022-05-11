package naumen.java.shelter.services;

import naumen.java.shelter.model.Animal;
import naumen.java.shelter.model.Shelter;
import naumen.java.shelter.repository.AnimalRepository;
import naumen.java.shelter.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShelterService {

    private ShelterRepository shelterRepository;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository){
        this.shelterRepository =shelterRepository;
    }

    public ShelterService() {}

    public Shelter getShelterById(Long id)
    {
        var allShelters = shelterRepository.findAll();
        var listShelters = new ArrayList<Shelter>();
        allShelters.forEach(animal -> {if (animal.getId() == id) listShelters.add(animal);});

        return listShelters.size() == 0 ? null : listShelters.stream().findFirst().get();
    }

    public ArrayList<Shelter> getShelters()
    {
        var allShelters= shelterRepository.findAll();
        var listShelters = new ArrayList<Shelter>();
        allShelters.forEach(listShelters::add);
        return listShelters;
    }

    public void saveShelter(Shelter shelter)
    {
        shelterRepository.save(shelter);
    }
}
