package org.example.controllers;

import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final Service service;

    @Autowired
    public MyController(Service service) {
        this.service = service;
    }

    @GetMapping("/unique")
    public void createUniqueParams() {
        service.createUniqueParams();
    }

    @GetMapping("/well")
    public void createParamsWellsInRange(@RequestParam(name = "wellStart", defaultValue = "10") Integer wellStart,
                                         @RequestParam(name = "wellEnd", defaultValue = "30") Integer wellEnd) {
        service.createParamsWellsInRange(wellStart, wellEnd);
    }

    @GetMapping("/dep")
    public void createDepartmentsAndWells() {
        service.createDepartmentsAndWells();
    }
}
