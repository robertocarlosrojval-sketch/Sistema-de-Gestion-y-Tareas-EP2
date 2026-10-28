package com.example.demo.service;

import com.example.demo.model.Proyecto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> obtenerProyectosPorUsuario(Usuario usuario) {
        return proyectoRepository.findByUsuario(usuario);
    }

    public Proyecto guardarProyecto(Proyecto proyecto, Usuario usuario) {
        long totalProyectos = proyectoRepository.countByUsuario(usuario);
        if (totalProyectos >= 3) {
            throw new IllegalArgumentException("Has alcanzado el límite máximo de 3 proyectos creados.");
        }
        proyecto.setUsuario(usuario);
        return proyectoRepository.save(proyecto);
    }
}