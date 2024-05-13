package com.ferreteria.web.controller;

import com.ferreteria.persistance.entity.ProductosEntity;
import com.ferreteria.server.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    private final ProductosService productosService;

    @Autowired
    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/todos/productos")
    public ResponseEntity<List<ProductosEntity>> getAll(){
        List<ProductosEntity> productos = productosService.getAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ProductosEntity> findByName(@PathVariable String nombre){
        ProductosEntity productos = this.productosService.findByName(nombre);
        if (productos != null){
            return ResponseEntity.ok(productos);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/precios/{precio}")
    public ResponseEntity<ProductosEntity>findByPrecio(@PathVariable double precio){
        ProductosEntity productos = this.productosService.findByPrecio(precio);
        if (productos != null){
            return ResponseEntity.ok(productos);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/stock/{stock}")
    public ResponseEntity<ProductosEntity>findByStock(@PathVariable int stock) {
        ProductosEntity productos = this.productosService.findByStock(stock);
        if (productos != null) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //                          Méthods             CRUD                          //

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<ProductosEntity> create(@RequestBody ProductosEntity producto) {
        ProductosEntity createdProducto = productosService.create(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
    }

    // READ
    @GetMapping("/id/{idProducto}")
    public ResponseEntity<ProductosEntity> getById(@PathVariable int idProducto){
        ProductosEntity producto = this.productosService.findById(idProducto);
        if (producto != null){
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PutMapping("/update/{idProducto}")
    public ResponseEntity<ProductosEntity> update(@PathVariable int idProducto, @RequestBody ProductosEntity producto) {
        ProductosEntity updatedProducto = productosService.update(idProducto, producto);
        if (updatedProducto != null) {
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Void> deleteById(@PathVariable int id) {
         productosService.deleteById(id);
         return ResponseEntity.noContent().build();
     }

}
//s<>