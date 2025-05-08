package com.producto.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producto.producto.model.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    ProductoEntity findByNombreProducto(String nombreProducto);

    Boolean existsByNombreProducto(String nombreProducto);

    void deleteByNombreProducto(String nombreProducto);
}
