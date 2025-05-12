package com.franquicia.api.controller;

import com.franquicia.api.model.Producto;
import com.franquicia.api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/sucursal/{sucursalId}")
    public Producto agregarProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
        return productoService.agregarProducto(sucursalId, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    @PutMapping("/{id}/stock")
    public Producto actualizarStock(@PathVariable Long id, @RequestParam int stock) {
        return productoService.actualizarStock(id, stock);
    }

    // Plus: actualizar nombre de producto
    @PutMapping("/{id}/nombre")
    public Producto actualizarNombre(@PathVariable Long id, @RequestParam String nombre) {
        return productoService.actualizarNombreProducto(id, nombre);
    }

    // Requisito: producto con más stock en sucursal
    @GetMapping("/sucursal/{sucursalId}/mas-stock")
    public Optional<Producto> productoConMasStock(@PathVariable Long sucursalId) {
        return productoService.obtenerProductoConMasStockEnSucursal(sucursalId);
    }
}
