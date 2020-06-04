package com.example.miodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;


@NoArgsConstructor
@Data
@NodeEntity
public class Ulica {


    private Long id;
    private String nazwa;

}
