package org.example.controllers;

import org.example.entities.Department;
import org.example.entities.Well;
import org.example.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MyController {
    private final Service service;

    @Autowired
    public MyController(Service service) {
        this.service = service;
    }

    @GetMapping("/unique")
    public Set<String> createUniqueParams() {
        return service.createUniqueParams();
    }

    @GetMapping("/wells")
    public TreeMap<String, HashMap<String, ArrayList<Double>>> createParamsWellsInRange(@RequestParam(name = "wellStart", defaultValue = "10") Integer wellStart,
                                                                                        @RequestParam(name = "wellEnd", defaultValue = "30") Integer wellEnd) {
        return service.createParamsWellsInRange(wellStart, wellEnd);
    }

    @GetMapping("/dep")
    public Map<Department, List<Well>> createDepartmentsAndWells() {
        return service.createDepartmentsAndWells();
    }
}
