package com.example.equipo_futbol.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;

    private String nombre;

    private String posicion;

    private Integer dorsal;

    private LocalDate fechaNac;

    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "idEquipo")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private List<Estadisticas_Jugador> estadisticas;
}
