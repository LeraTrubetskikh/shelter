package naumen.java.shelter.controllers;

import naumen.java.shelter.model.Shelter;
import naumen.java.shelter.services.AnimalService;
import naumen.java.shelter.services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public Shelter getSheltersById(@PathVariable("id") Long shelterId)
    {
        Shelter shelter = shelterServices.stream()
                .map(shelterService-> shelterService.getShelterId(shelterId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return shelter;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/shelters")
    @ResponseBody
    public ModelAndView getSheltersView(){
        var shelter = shelterServices.stream()
                .filter(shelterService -> shelterService instanceof ShelterService)
                .findFirst()
                .get()
                .getShelters();

        ModelAndView modelAndView = new ModelAndView("shelters");
        modelAndView.addObject("shelters", shelter);
        return modelAndView;
    }

    @GetMapping("/createShelter/{name}")
    public ModelAndView createShelter(@PathVariable String name)
    {
        shelterServices.stream()
                .filter(shelterService -> shelterService instanceof ShelterService)
                .findFirst()
                .get().saveShelter(name);

        return getSheltersView();
    }
}
