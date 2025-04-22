package com.example.equipo_futbol.Repository;

import com.example.equipo_futbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository <Partido, Integer> {
}