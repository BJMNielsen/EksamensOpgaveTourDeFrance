package com.example.eksamensopgavetourdefrance.service;

import com.example.eksamensopgavetourdefrance.model.Cyclist;
import com.example.eksamensopgavetourdefrance.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CyclistService {

    @Autowired
    CyclistRepository cyclistRepository;

    public List<Cyclist> getCyclists(){
        return cyclistRepository.findAll();
    }

    public Cyclist getCyclist(int id){
        return cyclistRepository.findById(id).orElseThrow(() -> new ResourceNotFound)
    }
}
