package com.franquicia.api.controller;

import com.franquicia.api.model.Sucursal;
import com.franquicia.api.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/franquicia/{franquiciaId}")
    public Sucursal agregarSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal) {
        return sucursalService.agregarSucursal(franquiciaId, sucursal);
    }

    // Plus: actualizar nombre de sucursal
    @PutMapping("/{id}/nombre")
    public Sucursal actualizarNombre(@PathVariable Long id, @RequestParam String nombre) {
        return sucursalService.actualizarNombreSucursal(id, nombre);
    }
}
