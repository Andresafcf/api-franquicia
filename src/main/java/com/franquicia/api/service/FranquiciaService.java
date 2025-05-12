package com.franquicia.api.service;

import com.franquicia.api.model.Franquicia;
import com.franquicia.api.repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Optional<Franquicia> obtenerFranquiciaPorId(Long id) {
        return franquiciaRepository.findById(id);
    }

    public List<Franquicia> listarFranquicias() {
        return franquiciaRepository.findAll();
    }

    public Franquicia actualizarNombreFranquicia(Long id, String nuevoNombre) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.setNombre(nuevoNombre);
        return franquiciaRepository.save(franquicia);
    }
}
