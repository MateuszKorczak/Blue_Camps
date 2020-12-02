package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.Camp;
import org.niebieskidom.bluecamps.entity.Child;
import org.niebieskidom.bluecamps.services.CampService;
import org.niebieskidom.bluecamps.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/camp")
public class CampController {
    private CampService campService;
    private ChildService childService;

    @Autowired
    public CampController(CampService campService, ChildService childService) {
        this.campService = campService;
        this.childService = childService;
    }

    @ModelAttribute("camps")
    public List<Camp> camps() {
        return campService.showCamps();
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
    public String addCamp(@Valid Camp camp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "camps/campForm";
        } else {
            campService.addCamp(camp);
            return "/camps/campList";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCamp(@PathVariable long id, Model model) {
        Optional<Camp> optionalCamp = campService.getCamp(id);
        Camp camp = optionalCamp.orElseThrow(() -> new EntityNotFoundException("Camp not found"));
        model.addAttribute("camp", camp);
        return "camps/campForm";
    }
//    @GetMapping("/author/modify")
//    public String updateAuthor(Author author) {
//        authorDao.modifyAuthor(author);
//        return "redirect:/author/list";
//    }
//
//    @PostMapping ("/author/modify")
//    public String updateAuthor(Model model, @RequestParam int id) {
//        Author author = authorDao.getAuthorById(id);
//        model.addAttribute("author", author);
//        return "/author/form";
//    }




    @GetMapping("/delete/{id}")
    public String deleteCamp(@PathVariable long id, Model model) {
        model.addAttribute("camp", campService.getCamp(id));
        return "/camps/deleteConfirmation";
    }

    @PostMapping("/delete/{id}")
    public String confirmDeleteCamp(Model model, @PathVariable long id) {
        //usunąć najpierw listę dzieci z tego obozu
        model.addAttribute("camp", campService.getCamp(id));
        campService.deleteCamp(id);
        return "/camps/campList";
    }


}
