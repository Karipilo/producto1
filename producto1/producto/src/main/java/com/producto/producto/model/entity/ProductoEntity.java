package com.producto.producto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "Producto")
    private String nombreProducto;

    @Column(name = "Precio")
    private double precioProducto;

    @Column(name = "Stock")
    private int stockProducto;

    @Column(name = "Tipo")
    private String tipoProducto;

    @Column(name = "Material")
    private String materialProducto;

}
