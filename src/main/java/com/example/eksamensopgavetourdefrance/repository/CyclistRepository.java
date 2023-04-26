package com.example.eksamensopgavetourdefrance.repository;

import com.example.eksamensopgavetourdefrance.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CyclistRepository extends JpaRepository<Cyclist, Integer> {

    List<Cyclist> findCyclistsByTeamId(int teamid);
    // Optional<List<Cyclist>> findCyclistsByTeamId(int teamid);

}
