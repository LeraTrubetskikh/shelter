package naumen.java.shelter.controllers;

import naumen.java.shelter.model.Animal;
import naumen.java.shelter.model.Shelter;
import naumen.java.shelter.services.AnimalService;
import naumen.java.shelter.services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Objects;

@Controller
public class AnimalController {

    private List<AnimalService> animalServices;
    private List<ShelterService> shelterServices;

    @Autowired
    public AnimalController(List<AnimalService> animalServices, List<ShelterService> shelterServices){
        this.animalServices = animalServices;
        this.shelterServices = shelterServices;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/animals")
    public String getMainPage(Model model){
        var animals = animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get()
                .getAnimals();
        model.addAttribute("animals", animals);
        model.addAttribute("animal", new Animal());
        return "animals";
    }

    @GetMapping(value = "/animal/{id}")
    public String getAnimalById(@PathVariable("id") Long animalId, Model model)
    {
        var animal = animalServices.stream()
                .map(animalService-> animalService.getAnimalById(animalId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        var shelter = shelterServices.stream()
                .map(animalService-> animalService.getShelterById(animal.getShelter()))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        model.addAttribute("animal", animal);
        model.addAttribute("shelter", shelter);
        return "animalCard";
    }

    @RequestMapping(value="/addAnimal", method=RequestMethod.GET)
    public String addAnimalForm(Model model){
        var shelters = shelterServices.stream()
                .filter(shelterService -> shelterService instanceof ShelterService)
                .findFirst()
                .get()
                .getShelters();
        model.addAttribute("animal", new Animal());
        model.addAttribute("shelters", shelters);
        return "addAnimal";
    }

    @RequestMapping(value="/addAnimal", method=RequestMethod.POST)
    public ModelAndView addAnimalSubmit(@ModelAttribute Animal animal, Model model){
        animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get().saveAnimal(animal);
        var animals = animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get()
                .getAnimals();
        ModelAndView modelAndView = new ModelAndView("animals");
        modelAndView.addObject("animals", animals);
        return modelAndView;
    }
}
