package com.example.miodb.repository;

import com.example.miodb.model.Polaczenie;
import com.example.miodb.model.Test;
import com.example.miodb.model.Ulica;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UlicaRepository extends Neo4jRepository<Ulica, Long>{

    @Query("MATCH (a:Street) return a.name")
    List<String> getAllUlica();

    @Query("MATCH (a:Street { name: 'Sokołowska' }),(b:Street { name:'Brzeska' }), " +
            "p = AllShortestPaths((a)-[r:CONNECT*]-(b)) " +
            "where ALL (r IN relationships(p) Where EXISTS (r.metry)) " +
            "UNWIND relationships(p) AS  rel " +
            "RETURN p,sum(rel.metry) as suma order by suma asc " +
            "LIMIT 1")
    Test getShortesPath(@Param("ulica1") String ulica1, @Param("ulica2") String ulica2);
}
