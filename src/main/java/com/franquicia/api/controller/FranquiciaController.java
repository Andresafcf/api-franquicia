package com.franquicia.api.controller;

import com.franquicia.api.model.Franquicia;
import com.franquicia.api.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public Franquicia crearFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.crearFranquicia(franquicia);
    }

    @GetMapping
    public List<Franquicia> listarFranquicias() {
        return franquiciaService.listarFranquicias();
    }

    // Plus: actualizar nombre de la franquicia
    @PutMapping("/{id}/nombre")
    public Franquicia actualizarNombre(@PathVariable Long id, @RequestParam String nombre) {
        return franquiciaService.actualizarNombreFranquicia(id, nombre);
    }
}
