package naumen.java.shelter.controllers;

import naumen.java.shelter.model.Animal;
import naumen.java.shelter.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class AnimalController {

    private List<AnimalService> animalServices;

    @Autowired
    public AnimalController(List<AnimalService> animalServices){ this.animalServices = animalServices;}

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/animals")
    @ResponseBody
    public ModelAndView getAnimals(){
        var animal = animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get()
                .getAnimalss();
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

    @GetMapping("/createAnimal/{name}")
    public ModelAndView createAnimal(@PathVariable String name)
    {
        animalServices.stream()
                .filter(animalService -> animalService instanceof AnimalService)
                .findFirst()
                .get().saveAnimal(name);

        return getAnimals();
    }

//    @GetMapping("/animalsView")
//    public ModelAndView getAnimalsView()
//    {
//        List<Animal> animals = animalServices.stream()
//                .filter(animalService -> animalService instanceof AnimalService)
//                .findFirst()
//                .get()
//                .getAnimalss();
//        ModelAndView modelAndView = new ModelAndView("animals");
//        modelAndView.addObject("animals", animals);
//        return modelAndView;
//    }
}
