package com.example.demo.repository;

import com.example.demo.model.Proyecto;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByUsuario(Usuario usuario);
    long countByUsuario(Usuario usuario);
}