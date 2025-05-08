package com.producto.producto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioProducto;
    private int stockProducto;
    private String tipoProducto;
    private String materialProducto;
}
