package com.example.miodb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@NoArgsConstructor
@Data
public class Test {

    private Collection<Map<Ulica, Polaczenie>> p;

    private int suma;

    public Test(Collection<Map<Ulica, Polaczenie>> p, int suma) {
        this.p = p;
        this.suma = suma;
    }
}
