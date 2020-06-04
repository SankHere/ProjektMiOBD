package com.example.miodb.repository;

import com.example.miodb.model.Ulica;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UlicaRepository extends Neo4jRepository<Ulica, Long>{

}
