package com.example.miodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.List;


@NoArgsConstructor
@Data
@NodeEntity
public class Ulica {

    @Id
    private Long id;
    private String nazwa;

    @Relationship(type="CONNECT") private List<Polaczenie> polaczenie;


    public Ulica(String nazwa) {
        this.nazwa = nazwa;
    }


}


