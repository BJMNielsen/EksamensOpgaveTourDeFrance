package com.example.eksamensopgavetourdefrance.repository;

import com.example.eksamensopgavetourdefrance.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyclistRepository extends JpaRepository<Cyclist, Integer> {
}
