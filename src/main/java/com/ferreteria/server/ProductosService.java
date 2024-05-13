package com.ferreteria.server;

import com.ferreteria.persistance.entity.ProductosEntity;
import com.ferreteria.persistance.repository.ProductosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    private final ProductosRespository productosRespository;

    @Autowired
    public ProductosService(ProductosRespository productosRespository) {
        this.productosRespository = productosRespository;
    }

    public List<ProductosEntity> getAll(){
        return productosRespository.findAll();
    }



    public ProductosEntity findByName(String nombre){
        return productosRespository.findAllByNombre(nombre);
    }

    public ProductosEntity findByPrecio(double precio){
        return productosRespository.findByPrecio(precio);
    }

    public ProductosEntity findByStock(int stock){
        return productosRespository.findByStock(stock);
    }

    //                  CRUD    Methods

    // CREATE
    public ProductosEntity create(ProductosEntity producto) {
        return productosRespository.save(producto);
    }

    // READ
    public ProductosEntity findById(int idProducto){
        return productosRespository.findByIdProducto(idProducto);
    }

    // UPDATE
    public ProductosEntity update(int id, ProductosEntity producto) {
        ProductosEntity existingProducto = productosRespository.findByIdProducto(id);
        if (existingProducto != null) {
            producto.setIdProducto(id); // Asegúrate de establecer el ID del producto que se va a actualizar
            return productosRespository.save(producto);
        } else {
            return null; // o puedes lanzar una excepción o manejar el caso de que el producto no exista
        }
    }

    // DELETE
    public void deleteById(int id) {
        productosRespository.deleteById(id);
    }

}
//s<>