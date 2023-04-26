package com.example.eksamensopgavetourdefrance.service;

import com.example.eksamensopgavetourdefrance.exception.ResourceAlreadyExistsException;
import com.example.eksamensopgavetourdefrance.exception.ResourceNotFoundException;
import com.example.eksamensopgavetourdefrance.model.Cyclist;
import com.example.eksamensopgavetourdefrance.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CyclistService {

    @Autowired
    CyclistRepository cyclistRepository;

    // metode til at vise alle cyclister.
    public List<Cyclist> getCyclists(){
        return cyclistRepository.findAll();
    }

    // metode til at finde specifik cyclist ud fra id.
    public Cyclist getCyclist(int id){
        return cyclistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cyclist with id: " + id + " Could not be found."));
    }

    // Metode til at post/add/create en cyclist
    public ResponseEntity<Cyclist> addCyclist(Cyclist cyclist) {
        // Først tjekker vi om cyclisten allerede eksistere, så vi ikke overrider den hvis den eksistere. Det gør vi med put.
        boolean exists = cyclistRepository.existsById(cyclist.getId());
        if (!exists){
            // Hvis den ikke existere, så laver vi en ny og gemmer i databasen.
            Cyclist newCyclist = cyclistRepository.save(cyclist);
            return new ResponseEntity<>(newCyclist, HttpStatus.OK);
        }
        // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
        throw new ResourceAlreadyExistsException("Cyclist with id: " + cyclist.getId() + " already exists and therefore can't be added.");

        // Add en exception der kan handle hvis man prøver at lave en cyclist uden et hold der eksistere. Brug resourcenotfoundexception.
    }

    // Metode til put/ Update. Vi får den specifikke
    public ResponseEntity<Cyclist> updateCyclist(Cyclist cyclist) {
        // Vi gemmer cyclisten som et Json objekt med de nye værdier i frontend, der så sendes ude fra frontenden hertil (cyclist)
        // og saver ham i databasen.
        boolean exists = cyclistRepository.existsById(cyclist.getId());
        if (exists){
            Cyclist updatedCyclist = cyclistRepository.save(cyclist);
            return new ResponseEntity<>(updatedCyclist, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Cyclist with id: " + cyclist.getId() + " doesn't exist.");
    }

    public ResponseEntity<Cyclist> deleteCyclist(int id) {
        //Måske lav en metode der tjekker om en cyclist eksistere, da den bruges flere steder
        // Først tjekker vi om han existerer.
        boolean exists = cyclistRepository.existsById(id);
        if (exists){
            // Hvis han existerer deleted vi ham.
            Cyclist deletedCyclist = getCyclist(id);
            cyclistRepository.deleteById(deletedCyclist.getId());
            return new ResponseEntity<>(deletedCyclist, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Cyclist with id: " + id + " does not exist and could therefore not be deleted.");
    }
}
