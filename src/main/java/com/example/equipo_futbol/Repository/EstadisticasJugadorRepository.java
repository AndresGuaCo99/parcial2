package com.example.equipo_futbol.Repository;

import com.example.equipo_futbol.Model.Estadisticas_Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<Estadisticas_Jugador, Integer> {
}
