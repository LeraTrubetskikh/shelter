package naumen.java.shelter.controllers;

import naumen.java.shelter.model.Shelter;
import naumen.java.shelter.services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
