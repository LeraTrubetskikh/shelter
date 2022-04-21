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

    protected List<Shelter> shelters;
    private ShelterRepository shelterRepository;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository){
        this.shelterRepository =shelterRepository;
    }

    public ShelterService()
    {
//        shelters = new ArrayList<>();
//        shelters.add(new Shelter("Первый приют", 1L));
//        shelters.add(new Shelter("Второй приют", 2L));
//        shelters.add(new Shelter("Третий приют", 3L));
    }

    public Shelter getShelterId(Long id)
    {
        List<Shelter> found =
            shelters.stream().filter(shelter -> shelter.getId() == id).collect(Collectors.toList());
            return found.size() == 0 ? null : found.stream().findFirst().get();
    }

    public ArrayList<Shelter> getShelters()
    {
        var allShelters= shelterRepository.findAll();
        var listShelters = new ArrayList<Shelter>();
        allShelters.forEach(listShelters::add);
        return listShelters;
    }

    public void saveShelter(String name)
    {
        Shelter shelter = new Shelter(name);
        shelterRepository.save(shelter);
    }
}
