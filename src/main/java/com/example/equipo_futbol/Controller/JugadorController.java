package com.example.equipo_futbol.Controller;

import com.example.equipo_futbol.Model.Jugador;
import com.example.equipo_futbol.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> listAll() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Integer id) {
        return ResponseEntity.of(jugadorService.getJugadorById(id));
    }

    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        return jugadorService.createJugador(jugador);
    }

    @PutMapping("/{id}")
    public Jugador update(@PathVariable Integer id, @RequestBody Jugador jugador) {
        return jugadorService.updateJugador(id, jugador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> byEquipo(@PathVariable Integer equipoId) {
        return jugadorService.findByEquipoId(equipoId);
    }

    @GetMapping("/goles/{minGoles}")
    public List<Jugador> byGoles(@PathVariable Integer minGoles) {
        return jugadorService.findJugadoresConMasGoles(minGoles);
    }
}