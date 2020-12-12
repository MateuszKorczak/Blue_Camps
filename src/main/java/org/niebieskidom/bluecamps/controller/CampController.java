package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.Camp;
import org.niebieskidom.bluecamps.entity.Child;
import org.niebieskidom.bluecamps.repositories.CampRepository;
import org.niebieskidom.bluecamps.repositories.ChildRepository;
import org.niebieskidom.bluecamps.services.CampService;
import org.niebieskidom.bluecamps.services.ChildService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/camp")
public class CampController {


    private final CampService campService;
    private final ChildService childService;
    private final CampRepository campRepository;
    private final ChildRepository childRepository;


    public CampController(CampService campService, ChildService childService, CampRepository campRepository, ChildRepository childRepository) {
        this.campService = campService;
        this.childService = childService;
        this.campRepository = campRepository;
        this.childRepository = childRepository;
    }


    @ModelAttribute("children")
    public List<Child> children() {
        return childService.getChildren();
    }

    @GetMapping("/all")
    public String showAllCamps(Model model) {
        List<Camp> camps = campService.showCamps();
        model.addAttribute("camps", camps);
        return "camps/campList";
    }

    @GetMapping("/add")
    public String addCamp(Model model) {
        model.addAttribute("camp", new Camp());
        return "camps/campForm";
    }


    @PostMapping("/add")
    public String addCamp(@Valid Camp camp, BindingResult bindingResult) {
        if (camp.getStartDate().after(camp.getEndDate())) {
            FieldError error = new FieldError("startDate", "endDate", "Data końcowa obozu nie może być wcześniejsza niż data początkowa");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            return "camps/campForm";
        } else {
            campService.addCamp(camp);
            return "redirect:/camp/all";
        }
    }


    @PostMapping("/edit")
    public String editCamp(Model model, @RequestParam long id) {
        Optional<Camp> camp = campService.getCamp(id);
        model.addAttribute("camp", camp);
        return "camps/campForm";
    }


    @PostMapping("delete")
    public String deleteCamp(Model model, @RequestParam long id) {
        model.addAttribute("id", id);
        return "camps/deleteConfirmation";
    }

    @PostMapping("delete/confirmed")
    public String executeDeleteCamp(@RequestParam Long id) {
        Optional<Camp> optionalCamp = campService.getCamp(id);
        Camp camp = optionalCamp.orElse(null);
        if (camp == null) {                   //dodaj obsługę błędu
            return "have problems";
        }
        campService.deleteCamp(id);
        return "redirect:/camp/all";
    }

    @GetMapping("/campList-by-date/{startDate}/{endDate}")
    public String listByDateBetween(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate, Model model){
        List<Camp> camps = campRepository.findCampByStartDateEqualsCurrentYear(startDate,endDate);
        model.addAttribute("camps",camps);
        return "camps/campList";
    }

}
