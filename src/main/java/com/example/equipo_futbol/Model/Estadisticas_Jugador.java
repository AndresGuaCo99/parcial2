package com.example.equipo_futbol.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estadisticas_Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idEstadistica;

    @ManyToOne
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_Jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido", referencedColumnName = "id_Partido")
    private Partido partido;

    private Integer minutosJugados;

    private Integer goles;

    private Integer asistencias;

    private Integer tarjetasAmarillas;

    private Integer tarjetasRojas;
}
