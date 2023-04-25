package com.example.eksamensopgavetourdefrance.repository;

import com.example.eksamensopgavetourdefrance.model.Cyclist;
import com.example.eksamensopgavetourdefrance.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
