package com.example.equipo_futbol.Controller;

import com.example.equipo_futbol.Model.Entrenador;
import com.example.equipo_futbol.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> listAll(){
        return entrenadorService.getAllEntrenadores();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadoresById(@PathVariable Integer id) {
        return ResponseEntity.of(entrenadorService.getEntrenadoresById(id));
    }

    @PostMapping
    public Entrenador createEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.createEntrenador(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador update(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        return entrenadorService.updateEntrenador(id, entrenador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Integer id) {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();

    }
}