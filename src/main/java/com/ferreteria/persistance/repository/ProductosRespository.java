package com.ferreteria.persistance.repository;

import com.ferreteria.persistance.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductosRespository extends JpaRepository<ProductosEntity, Integer> {

    List<ProductosEntity> findAll();

    @Query(value = "SELECT p FROM ProductosEntity p WHERE p.idProducto =:idProducto")
    ProductosEntity findByIdProducto(@Param("idProducto")int idProducto);

    @Query(value = "SELECT p FROM ProductosEntity p WHERE p.nombre =:nombre")
    ProductosEntity findAllByNombre(@Param("nombre")String nombre);

    @Query(value = "SELECT p FROM ProductosEntity p WHERE p.precio =:precio")
    ProductosEntity findByPrecio(@PathVariable("precio")double precio);

    @Query(value = "SELECT p FROM  ProductosEntity p WHERE p.stock =:stock")
    ProductosEntity findByStock(@PathVariable("stock")int stock);

}
//<>