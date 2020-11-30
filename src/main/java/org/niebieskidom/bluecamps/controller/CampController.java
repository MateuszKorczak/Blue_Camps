package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.Camp;
import org.niebieskidom.bluecamps.services.CampService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/camp")
public class CampController {
    private CampService campService;

    @RequestMapping("/testCamp")
    public Camp testCamp() {
        return new Camp("Camp's name", LocalDateTime.now().minusDays(4), LocalDateTime.now(), "Mazury", 90);
    }


    @PostMapping("")
    public void createCamp(@RequestBody Camp camp) {
        campService.addCamp(camp);
    }


    @GetMapping("/all")
    public String showAllCamps(Model model) {
        List<Camp> camps = campService.getCamps();
        model.addAttribute("camps", camps);
        return "camps/campList";
    }

}
