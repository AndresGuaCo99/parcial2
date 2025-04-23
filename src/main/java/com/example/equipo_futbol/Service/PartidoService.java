package com.example.equipo_futbol.Service;


import com.example.equipo_futbol.Model.Partido;
import com.example.equipo_futbol.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> getPartidoById(Integer id) {
        return partidoRepository.findById(id);
    }

    public Partido createPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido updatePartido(Integer id, Partido datos) {
        return partidoRepository.findById(id)
                .map(p -> {
                    p.setFecha(datos.getFecha());
                    p.setEstadio(datos.getEstadio());
                    p.setEquipoLocal(datos.getEquipoLocal());
                    p.setEquipoVisita(datos.getEquipoVisita());
                    p.setGolesLocal(datos.getGolesLocal());
                    p.setGolesVisita(datos.getGolesVisita());
                    return partidoRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }

    public void deletePartido(Integer id) {
        partidoRepository.deleteById(id);
    }

    public Integer totalGolesPorEquipo(Integer equipoId) {
        return partidoRepository.totalGolesPorEquipo(equipoId);
    }

    public List<Map<String, Object>> resultadosDePartidos() {
        return partidoRepository.findResultadosDePartidos();
    }
}
