package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.Camp;
import org.niebieskidom.bluecamps.services.CampService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/camp")
public class CampController {
    private CampService campService;

    public CampController(CampService campService) {
        this.campService = campService;
    }

    @RequestMapping("/testCamp")
    public Camp testCamp() {
        return new Camp("Camp's name", LocalDate.now().minusDays(4), LocalDate.now(), "Mazury", 90);
    }

//
//    @PostMapping("")
//    public void createCamp(@RequestBody Camp camp) {
//        campService.addCamp(camp);
//    }


    @GetMapping("/all")
    public String showAllCamps(Model model) {
        List<Camp> camps = campService.showCamps();
        model.addAttribute("camps", camps);
        return "camps/campList";
    }

    @GetMapping("/form")
    public String addCamp(Model model) {
        model.addAttribute("camp", new Camp());
        return "camps/campForm";
    }

    @PostMapping("/form")
    public String addCamp(@Valid Camp camp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "camps/campForm";
        } else {
            campService.addCamp(camp);
            return "home";
        }
    }

    @GetMapping("/form/{id}")
    public String editCamp(@PathVariable Long id, Model model) {
        Optional<Camp> optionalCamp = campService.getCamp(id);
        Camp camp = optionalCamp.orElseThrow(() -> new EntityNotFoundException("Camp not found"));
        model.addAttribute("camp", camp);
        return "camps/campForm";
    }


}
