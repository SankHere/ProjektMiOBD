package com.example.miodb.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "CONNECT")
public class Polaczenie {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @Property
    private int odleglosc;
    @Property
    private int bus;
    @Property
    private int samochod;

    @StartNode
    private Ulica ulica;
    @EndNode
    private Ulica ulica1;
}