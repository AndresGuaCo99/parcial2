package com.example.equipo_futbol.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idPartido;

    private LocalDate fecha;

    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local", referencedColumnName = "idEquipo")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita", referencedColumnName = "idEquipo")
    private Equipo equipoVisita;

    private Integer golesLocal;

    private Integer golesVisita;

    @OneToMany(mappedBy = "partido")
    private List<Estadisticas_Jugador> estadisticas;
}
