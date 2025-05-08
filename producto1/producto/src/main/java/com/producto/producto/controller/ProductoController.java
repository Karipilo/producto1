package com.producto.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.producto.producto.model.Producto;
import com.producto.producto.service.ProductoService;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crearProducto")
    // Responder según acción o resultado (404,200...)
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    @GetMapping("/obtenerProducto/{nombreProducto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String nombreProducto) {
        Producto producto = productoService.obtenerProducto(nombreProducto);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/productos")
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @PutMapping("/producto/{nombre}")
    public String actualizarProducto(@PathVariable String nombre, @RequestBody Producto producto) {
        return productoService.actualizarProducto(nombre, producto);
    }

    @DeleteMapping("/producto/{nombre}")
    public String eliminarProducto(@PathVariable String nombre) {
        return productoService.eliminarProducto(nombre);
    }
}
