package com.example.eksamensopgavetourdefrance.config;

import com.example.eksamensopgavetourdefrance.model.Cyclist;
import com.example.eksamensopgavetourdefrance.model.Team;
import com.example.eksamensopgavetourdefrance.repository.CyclistRepository;
import com.example.eksamensopgavetourdefrance.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Configuration annotationen og ApplicationRunner klassen gør at run metoden køre når applikationen starter.
@Configuration
public class StartupDataConfig implements ApplicationRunner {


    // Her laver vi dependency injection med constructoren. Vi kan også bare lave autowired.
    /*
    CyclistRepository cyclistRepository;
    TeamRepository teamRepository;

    public StartupDataConfig(TeamRepository teamRepository, CyclistRepository cyclistRepository){
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }
    */

    @Autowired
    CyclistRepository cyclistRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Vi laver 2 teams der bliver lavet ved hver opstart.
        Team teamEasyOn = new Team("Team Easy On");
        Team teamGoFast = new Team("Team Go Fast");
        // Vi gemmer vores teams i databasen, så vi kan gemme vores cyklister i vores teams.
        teamRepository.save(teamEasyOn);
        teamRepository.save(teamGoFast);

        // Vi laver 3 ryttere, vi sætter deres id = 0, så ved spring at den skal autogen et nyt ID til den.
        // Vi kunne også lave en custom constructor der tager alle arguments bortset fra id, men vi brugte @AllArgsConstructor til
        // at få lombok til at lave en constructor med alle arguments, så vi bruger bare den og sætter id = 0, for så autogenerator den bare et nyt id.
        Cyclist Lars = new Cyclist(0, 24, "Lars", 3544, 12, 32, teamEasyOn);
        Cyclist Børge = new Cyclist(0, 17, "Børge", 1345, 33, 11, teamEasyOn);
        Cyclist Kevin = new Cyclist(0, 22, "Kevin", 7567, 24, 52, teamGoFast);

        // VI laver en liste til vores cyklister.
        List<Cyclist> cyclistListe = new ArrayList<>();
        // Så bruger vi Collections.addAll(List, entities,...) til at specify vores liste først, og derefter de objekter vi vil store i den.
        Collections.addAll(cyclistListe, Lars, Børge, Kevin);
        // Så gemmer vi vores liste af cyklister i databasen. Den gemmer hver cyklist i listen individuel i databasen.
        cyclistRepository.saveAll(cyclistListe);

    }
}
