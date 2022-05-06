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
    @ResponseBody
    public ModelAndView getAnimalsView(){
        var animal = animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get()
                .getAnimals();
//        return animal;
//        List<Animal> animals = new ArrayList<>();
//        animalServices.forEach(animalService ->animals.addAll(animalService.getAnimals()));
//        return animals;

        ModelAndView modelAndView = new ModelAndView("animals");
        modelAndView.addObject("animals", animal);
        return modelAndView;
    }

    @GetMapping(value = "/animal/{id}")
    @ResponseBody
    public Animal getAnimalsById(@PathVariable("id") Long animalId)
    {
        Animal animal = animalServices.stream()
                .map(animalService-> animalService.getAnimalId(animalId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return animal;
    }

    @GetMapping(value = "animal")
    @ResponseBody
    public Animal getAnimalsByParamId(@RequestParam("id") Long animalId)
    {
        Animal animal = animalServices.stream()
                .map(animalService -> animalService.getAnimalId(animalId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return animal;
    }

//    @GetMapping("/createAnimal/{name}")
//    public ModelAndView createAnimal(@PathVariable String name)
//    {
//        animalServices.stream()
//                .filter(animalService -> animalService instanceof AnimalService)
//                .findFirst()
//                .get().saveAnimal(name);
//
//        return getAnimalsView();
//    }

    @RequestMapping(value="/addAnimal", method=RequestMethod.GET)
    public String getAnimalViewFrom(Model model){
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
    public ModelAndView getAnimalViewSubmit(@ModelAttribute Animal animal, Model model){
        animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get().saveAnimal(animal);
        //model.addAttribute("animals", animal);
        var newModel = getAnimalsView();
        return newModel;
    }

//    @GetMapping("/animalsView")
//    public ModelAndView getAnimalsView()
//    {
//        List<Animal> animals = animalServices.stream()
//                .filter(animalService -> animalService instanceof AnimalService)
//                .findFirst()
//                .get()
//                .getAnimals();
//        ModelAndView modelAndView = new ModelAndView("animals");
//        modelAndView.addObject("animals", animals);
//        return modelAndView;
//    }
}
