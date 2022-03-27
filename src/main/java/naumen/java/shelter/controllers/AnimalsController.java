package naumen.java.shelter.controllers;

import naumen.java.shelter.model.Animal;
import naumen.java.shelter.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimalsController {

    private List<AnimalService> animalServices;

    @Autowired
    public AnimalsController(List<AnimalService> animalServices){ this.animalServices = animalServices;}

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/animals")
    @ResponseBody
    public List<Animal> getAnimals(){
        List<Animal> animals = new ArrayList<>();
        animalServices.forEach(animalService ->animals.addAll(animalService.getAnimals()));
        return animals;
    }

}
