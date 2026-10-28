package com.example.demo.service;

import com.example.demo.model.Proyecto;
import com.example.demo.model.Tarea;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    public Tarea crearTarea(Tarea tarea, Long proyectoId) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        tarea.setProyecto(proyecto);
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarEstado(Long tareaId, String nuevoEstado) {
        Tarea tarea = tareaRepository.findById(tareaId)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setEstado(nuevoEstado);
        return tareaRepository.save(tarea);
    }
}