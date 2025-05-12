package com.franquicia.api.service;

import com.franquicia.api.model.Producto;
import com.franquicia.api.model.Sucursal;
import com.franquicia.api.repository.ProductoRepository;
import com.franquicia.api.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Producto agregarProducto(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        producto.setSucursal(sucursal);
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    public Producto actualizarStock(Long productoId, int nuevoStock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(nuevoStock);
        return productoRepository.save(producto);
    }

    public Producto actualizarNombreProducto(Long productoId, String nuevoNombre) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(nuevoNombre);
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoConMasStockEnSucursal(Long sucursalId) {
        List<Producto> productos = productoRepository.findBySucursalId(sucursalId);
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getStock));
    }
}
