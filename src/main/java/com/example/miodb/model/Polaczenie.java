package com.example.miodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "CONNECT")
public class Polaczenie {

    @Id
    @GeneratedValue
    private Long relationshipId;
    @Property
    private int samochód;
    @Property
    private int autobus;
    @Property
    private int metry;

    @StartNode
    private Ulica ulica;
    @EndNode
    private Ulica ulica1;
}