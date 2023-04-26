package com.example.eksamensopgavetourdefrance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;

//Lombok autogenerere setters, getter og constructors
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Team {
    // Et team skal have et ID, og en liste af cyclister i sig. Derfor One team to many cyclists.

    @Id
    // laver automatisk et nyt id hver gang vi laver et team
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    @JsonBackReference // JsonBackReference gør at du ikke får en eternal bug, der kun viser den første cyclist i listen.
    private List<Cyclist> cyclists;

    //In Spring JPA, the mappedBy attribute is used to indicate the inverse side of a bidirectional relationship between two entities.
    // It is used in conjunction with the @OneToMany, @OneToOne, or @ManyToMany annotations to specify the name of the attribute in the target entity that maps back to the source entity.
    //
    //The mappedBy attribute is used on the non-owning side of the relationship, which means the entity that does not have the foreign key column.
    // The owning side of the relationship is the entity that has the foreign key column.

    // mappedBy gør at vi kun får 2 tabeller i vores bidirectional database.
    // Hvis du ikke har mappedBy på, så laver hibernate en ekstra tabel til foreign keys og det ID den er mapped til.
    // Hvis din database skal være bidirectional, så skal mappedBy være på. Ellers kommer den 3 tabel.


    public Team(String name){
        this.name = name;
    }
}
