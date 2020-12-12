package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.Camp;
import org.niebieskidom.bluecamps.entity.Child;
import org.niebieskidom.bluecamps.services.ChildService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/child")
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }


    @GetMapping("/list")
    public String showAllChildren(Model model) {
        List<Child> children = childService.getChildren();
        model.addAttribute("children", children);
        return "children/childrenList";
    }


    @GetMapping("/add")
    public String addChild(Model model) {
        model.addAttribute("child", new Child());
        return "children/childrenForm";
    }


    @PostMapping("/add")
    public String addChild(@Valid Child child, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "children/childrenForm";
        } else {
            childService.addChild(child);
            return "redirect:/child/list";
        }
    }

    @PostMapping("/edit")
    public String editChild(Model model, @RequestParam long id) {
        Optional<Child> child = childService.getChild(id);
        model.addAttribute("child", child);
        return "children/childrenForm";
    }


    @PostMapping("delete")
    public String deleteChild(Model model, @RequestParam long id) {
        model.addAttribute("id", id);
        return "children/deleteConfirmation";
    }

    @PostMapping("delete/confirmed")
    public String executeDeleteChild(@RequestParam Long id) {
        Optional<Child> optionalChild = childService.getChild(id);
        Child child = optionalChild.orElse(null);
        if (child == null) {
            return "Haven't child like this.";
        }

        childService.deleteChild(id);
        return "redirect:/child/list";
    }


}
