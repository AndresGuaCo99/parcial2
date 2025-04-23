package com.example.equipo_futbol.Controller;

import com.example.equipo_futbol.Model.Equipo;
import com.example.equipo_futbol.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> listAll() {
        return equipoService.getAllEquipos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getById(@PathVariable Integer id) {
        return ResponseEntity.of(equipoService.getEquiposById(id));
    }

    @PostMapping("guardar")
    public Equipo create(@RequestBody Equipo equipo) {
        return equipoService.createEquipo(equipo);
    }

    @PutMapping("/{id}")
    public Equipo update(@PathVariable Integer id, @RequestBody Equipo equipo) {
        return equipoService.updateEquipo(id, equipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();

    }
}