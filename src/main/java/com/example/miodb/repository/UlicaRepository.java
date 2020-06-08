package com.example.miodb.repository;

import com.example.miodb.model.Ulica;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UlicaRepository extends Neo4jRepository<Ulica, Long>{

    @Query("MATCH (a:Street) return a.name")
    List<String> getAllUlica();
}
