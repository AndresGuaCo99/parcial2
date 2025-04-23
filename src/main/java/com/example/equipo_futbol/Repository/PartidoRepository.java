package com.example.equipo_futbol.Repository;

import com.example.equipo_futbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository <Partido, Integer> {
    @Query(value = "SELECT " +
            "COALESCE((SELECT SUM(goles_local) FROM partido WHERE equipo_local = :equipoId),0) + " +
            "COALESCE((SELECT SUM(goles_visita) FROM partido WHERE equipo_visita = :equipoId),0)",
            nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("equipoId") Integer equipoId);

    /**
     * Obtener los resultados de todos los partidos indicando nombres de equipos
     * Retorna una lista de mapas con: id_partido, local, visita, goles_local, goles_visita
     */
    @Query(value = "SELECT p.id_partido, l.nombre AS local, v.nombre AS visita, p.goles_local, p.goles_visita " +
            "FROM partido p " +
            "JOIN equipo l ON p.equipo_local = l.id_equipo " +
            "JOIN equipo v ON p.equipo_visita = v.id_equipo",
            nativeQuery = true)
    List<Map<String, Object>> findResultadosDePartidos();
}