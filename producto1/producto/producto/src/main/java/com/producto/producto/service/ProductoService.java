package com.producto.producto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.producto.model.Producto;
import com.producto.producto.model.entity.ProductoEntity;
import com.producto.producto.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public String crearProducto(Producto prod) {
        try {
            Boolean estado = productoRepository.existsByNombreProducto(prod.getNombreProducto());
            if (!estado) {
                ProductoEntity productoNuevo = new ProductoEntity();
                productoNuevo.setIdProducto(prod.getIdProducto());
                productoNuevo.setNombreProducto(prod.getNombreProducto());
                productoNuevo.setPrecioProducto(prod.getPrecioProducto());
                productoNuevo.setStockProducto(prod.getStockProducto());
                productoNuevo.setTipoProducto(prod.getTipoProducto());
                productoNuevo.setMaterialProducto(prod.getMaterialProducto());
                productoRepository.save(productoNuevo);
                return "Producto creado exitosamente";
            }
            return "El producto ya existe";
        } catch (Exception e) {
            return "Error al crear el usuario";
        }

    }

    public Producto obtenerProducto(String nombreProducto) {
        try {
            ProductoEntity producto = productoRepository.findByNombreProducto(nombreProducto);
            if (producto != null) {
                Producto prod = new Producto(
                        producto.getIdProducto(),
                        producto.getNombreProducto(),
                        producto.getPrecioProducto(),
                        producto.getStockProducto(),
                        producto.getTipoProducto(),
                        producto.getMaterialProducto()
                );
                return prod;
            }
            return null;
        } catch (Exception e) {
            return null;

        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll().stream().map(producto -> new Producto(
                producto.getIdProducto(),
                producto.getNombreProducto(),
                producto.getPrecioProducto(),
                producto.getStockProducto(),
                producto.getTipoProducto(),
                producto.getMaterialProducto()
        )).collect(Collectors.toList());
    }

    public String actualizarProducto(String nombre, Producto prod) {
        ProductoEntity existente = productoRepository.findByNombreProducto(nombre);
        if (existente != null) {
            existente.setPrecioProducto(prod.getPrecioProducto());
            existente.setStockProducto(prod.getStockProducto());
            existente.setTipoProducto(prod.getTipoProducto());
            existente.setMaterialProducto(prod.getMaterialProducto());
            productoRepository.save(existente);
            return "Producto actualizado correctamente";
        }
        return "Producto no encontrado";
    }

    public String eliminarProducto(String nombreProducto) {
        ProductoEntity existente = productoRepository.findByNombreProducto(nombreProducto);
        if (existente != null) {
            productoRepository.delete(existente);
            return "Producto eliminado correctamente";
        }
        return "Producto no encontrado";
    }
}
