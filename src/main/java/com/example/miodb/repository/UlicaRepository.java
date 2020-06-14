package com.example.miodb.repository;

import com.example.miodb.model.Ulica;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UlicaRepository extends Neo4jRepository<Ulica, Long>{

    @Query("MATCH (a:Street) return a.name")
    List<String> getAllUlica();

    @Query("MATCH (start:Street {name: $ulica1}), (end:Street {name: $ulica2})\n" +
            "CALL gds.alpha.shortestPath.stream({\n" +
            "  nodeProjection: 'Street',\n" +
            "  relationshipProjection: {\n" +
            "    CONNECT: {\n" +
            "      type: 'CONNECT',\n" +
            "      properties: 'metry'\n" +
            "    }\n" +
            "  },\n" +
            "  startNode: start,\n" +
            "  endNode: end,\n" +
            "  relationshipWeightProperty: 'metry'\n" +
            "})\n" +
            "YIELD nodeId, cost\n" +
            "RETURN gds.util.asNode(nodeId).name AS name, cost")
    Iterable<Map<String, Object>> getShortesPath(@Param("ulica1") String ulica1, @Param("ulica2") String ulica2);

    @Query("MATCH (start:Street {name: $ulica1}), (end:Street {name: $ulica2})\n" +
            "CALL gds.alpha.shortestPath.stream({\n" +
            "  nodeProjection: 'Street',\n" +
            "  relationshipProjection: {\n" +
            "    CONNECT: {\n" +
            "      type: 'CONNECT',\n" +
            "      properties: 'autobus'\n" +
            "    }\n" +
            "  },\n" +
            "  startNode: start,\n" +
            "  endNode: end,\n" +
            "  relationshipWeightProperty: 'autobus'\n" +
            "})\n" +
            "YIELD nodeId, cost\n" +
            "RETURN gds.util.asNode(nodeId).name AS name, cost")
    Iterable<Map<String, Object>> getAutobusPath(@Param("ulica1") String ulica1, @Param("ulica2") String ulica2);


    @Query("MATCH (start:Street {name: $ulica1}), (end:Street {name: $ulica2})\n" +
            "CALL gds.alpha.shortestPath.stream({\n" +
            "  nodeProjection: 'Street',\n" +
            "  relationshipProjection: {\n" +
            "    CONNECT: {\n" +
            "      type: 'CONNECT',\n" +
            "      properties: 'samochód'\n" +
            "    }\n" +
            "  },\n" +
            "  startNode: start,\n" +
            "  endNode: end,\n" +
            "  relationshipWeightProperty: 'samochód'\n" +
            "})\n" +
            "YIELD nodeId, cost\n" +
            "RETURN gds.util.asNode(nodeId).name AS name, cost")
    Iterable<Map<String, Object>> getSamochodPath(@Param("ulica1") String ulica1, @Param("ulica2") String ulica2);
}
