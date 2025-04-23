package com.example.equipo_futbol.Controller;

import com.example.equipo_futbol.Model.EstadisticasJugador;
import com.example.equipo_futbol.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticasjugador")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping
    public List<EstadisticasJugador> listAll() {
        return estadisticasJugadorService.getAllEstadisticasJugador();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> getById(@PathVariable Integer id) {
        return ResponseEntity.of(estadisticasJugadorService.getEstadisiticasJugadorById(id));
    }

    @PostMapping
    public EstadisticasJugador create(@RequestBody EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorService.createEstadisticaJugador(estadisticasJugador);
    }
    @PutMapping("/{id}")
    public EstadisticasJugador update(@PathVariable Integer id, @RequestBody EstadisticasJugador estadisticasJugador){
        return estadisticasJugadorService.updateEstadisticaJugador(id, estadisticasJugador);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        estadisticasJugadorService.deleteEstadisticaJugador(id);
        return ResponseEntity.noContent().build();
    }
}
