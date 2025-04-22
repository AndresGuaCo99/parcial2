package com.example.equipo_futbol.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idEntrenador;
    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    private Equipo equipo;

}
