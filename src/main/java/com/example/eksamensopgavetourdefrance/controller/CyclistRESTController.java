package com.example.eksamensopgavetourdefrance.controller;

import com.example.eksamensopgavetourdefrance.model.Cyclist;
import com.example.eksamensopgavetourdefrance.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CyclistRESTController {

    @Autowired
    CyclistService cyclistService;

    @GetMapping("/cyclists")
    public List<Cyclist> getCyclists() {
        return cyclistService.getCyclists();
    }

    @GetMapping("/cyclist/{id}")
    public Cyclist getCyclist(@PathVariable int id){
        return cyclistService.getCyclist();
    }

    @PostMapping("/cyclist")
    public ResponseEntity<Cyclist> addCyclist(@RequestBody Cyclist cyclist){
        return
    }
}
