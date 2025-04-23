package com.example.equipo_futbol.Service;

import com.example.equipo_futbol.Model.Equipo;
import com.example.equipo_futbol.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> getEquiposById(Integer id) {
        return equipoRepository.findById(id);
    }
    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Integer id, Equipo datos) {
        return equipoRepository.findById(id)
                .map(e -> {
                    e.setNombre(datos.getNombre());
                    e.setCiudad(datos.getCiudad());
                    e.setFundacion(datos.getFundacion());
                    return equipoRepository.save(e);
                }).orElseThrow(()-> new RuntimeException("Equipo de futbol no encontrado"));
    }
    public void deleteEquipo(Integer id) {
        equipoRepository.deleteById(id);
    }
}
