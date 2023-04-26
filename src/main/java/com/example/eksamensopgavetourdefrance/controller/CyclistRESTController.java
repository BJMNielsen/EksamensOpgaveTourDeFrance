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

    // Finder alle cyclister.
    @GetMapping("/cyclists")
    public List<Cyclist> getCyclists() {
        return cyclistService.getCyclists();
    }

    // Finder cyclist ud fra id
    @GetMapping("/cyclist/{id}")
    public Cyclist getCyclist(@PathVariable int id){
        return cyclistService.getCyclist(id);
    }

    // Creater en cyclist.
    @PostMapping("/cyclist")
    public ResponseEntity<Cyclist> addCyclist(@RequestBody Cyclist cyclist){
        return cyclistService.addCyclist(cyclist);
    }

    // Update en cyclist.
    @PutMapping("/cyclist")
    public ResponseEntity<Cyclist> updateCyclist(@RequestBody Cyclist cyclist) {
        return cyclistService.updateCyclist(cyclist);
    }

    @DeleteMapping("/cyclist/{id}")
    public ResponseEntity<Cyclist> deleteCyclist(@PathVariable int id) {
        return cyclistService.deleteCyclist(id);
    }

    @GetMapping("/cyclists/{teamid}")
    public List<Cyclist> getCyclistsByTeamId(@PathVariable int teamid){
        return cyclistService.getCyclistsByTeamId(teamid);
    }
}
