package com.example.miodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Trasa {

    private String ulicaSkad;
    private String ulicaDokad;
    private String transport;

    public Trasa(String ulicaSkad, String ulicaDokad, String transport) {
        this.ulicaSkad = ulicaSkad;
        this.ulicaDokad = ulicaDokad;
        this.transport = transport;
    }
}
