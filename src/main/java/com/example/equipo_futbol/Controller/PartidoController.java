package com.example.equipo_futbol.Controller;

import com.example.equipo_futbol.Model.Partido;
import com.example.equipo_futbol.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidos")

public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> listAll() {
        return partidoService.getAllPartidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getById(@PathVariable Integer id) {
        return ResponseEntity.of(partidoService.getPartidoById(id));
    }

    @PostMapping
    public Partido create(@RequestBody Partido partido) {
        return partidoService.createPartido(partido);
    }

    @PutMapping("/{id}")
    public Partido update(@PathVariable Integer id, @RequestBody Partido partido) {
        return partidoService.updatePartido(id, partido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        partidoService.deletePartido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/goles/{equipoId}")
    public Integer totalGoles(@PathVariable Integer equipoId) {
        return partidoService.totalGolesPorEquipo(equipoId);
    }

    @GetMapping("/resultados")
    public List<Map<String, Object>> resultados() {
        return partidoService.resultadosDePartidos();
    }
}