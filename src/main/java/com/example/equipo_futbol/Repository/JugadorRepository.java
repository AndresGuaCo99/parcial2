package com.example.equipo_futbol.Repository;

import com.example.equipo_futbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :equipoId", nativeQuery = true)
    List<Jugador> findByEquipoId(@Param("equipoId") Integer equipoId);

    /**
     * Obtener los jugadores que han marcado mas de X goles
     */
    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadistica_jugador e ON j.id_jugador = e.id_jugador " +
            "GROUP BY j.id_jugador, j.nombre, j.posicion, j.dorsal, j.fecha_nac, j.nacionalidad, j.id_equipo " +
            "HAVING SUM(e.goles) > :goles", nativeQuery = true)
    List<Jugador> findJugadoresConMasGoles(@Param("goles") Integer goles);
}
