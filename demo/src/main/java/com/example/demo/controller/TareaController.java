package com.example.demo.controller;

import com.example.demo.model.Tarea;
import com.example.demo.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Map<String, Object> body) {
        Tarea tarea = new Tarea();
        tarea.setTitulo((String) body.get("titulo"));
        Long proyectoId = Long.valueOf(body.get("proyecto_id").toString());

        Tarea nuevaTarea = tareaService.crearTarea(tarea, proyectoId);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String nuevoEstado = body.get("estado");
        Tarea actualizada = tareaService.actualizarEstado(id, nuevoEstado);
        return ResponseEntity.ok(actualizada);
    }
}