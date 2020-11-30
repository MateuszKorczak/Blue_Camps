package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.services.ChildService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/child")
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }
}
