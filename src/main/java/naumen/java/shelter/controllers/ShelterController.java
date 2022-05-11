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

import java.util.List;
import java.util.Objects;

@Controller
public class ShelterController {

    private List<ShelterService> shelterServices;

    @Autowired
    public ShelterController(List<ShelterService> shelterServices){this.shelterServices = shelterServices;}

    @GetMapping(value = "/shelter/{id}")
    public String getShelterById(@PathVariable("id") Long shelterId, Model model)
    {
        var shelter = shelterServices.stream()
                .map(animalService-> animalService.getShelterById(shelterId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        model.addAttribute("shelter", shelter);
        return "shelterCard";
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/shelters")
    @ResponseBody
    public ModelAndView getSheltersView(){
        var shelters = shelterServices.stream()
                .filter(shelterService -> shelterService instanceof ShelterService)
                .findFirst()
                .get()
                .getShelters();

        ModelAndView modelAndView = new ModelAndView("shelters");
        modelAndView.addObject("shelters", shelters);
        return modelAndView;
    }

    @RequestMapping(value="/addShelter", method=RequestMethod.GET)
    public String addShelterForm(Model model){
        model.addAttribute("shelter", new Shelter());
        return "addShelter";
    }

    @RequestMapping(value="/addShelter", method=RequestMethod.POST)
    public ModelAndView addShelterSubmit(@ModelAttribute Shelter shelter, Model model){
        shelterServices.stream()
                .filter(shelterService -> shelterService instanceof ShelterService)
                .findFirst()
                .get()
                .saveShelter(shelter);
        var shelters = shelterServices.stream()
                .filter(shelterService -> shelterService instanceof ShelterService)
                .findFirst()
                .get()
                .getShelters();
        ModelAndView modelAndView = new ModelAndView("shelters");
        modelAndView.addObject("shelters", shelters);
        return modelAndView;
    }
}
