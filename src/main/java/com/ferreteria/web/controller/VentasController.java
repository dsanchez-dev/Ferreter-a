package com.ferreteria.web.controller;

import com.ferreteria.persistance.entity.VentasEntity;
import com.ferreteria.server.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    private final VentasService ventasService;

    @Autowired
    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    // READ
    @GetMapping("/todos")
    public ResponseEntity<List<VentasEntity>> getAll() {
        List<VentasEntity> ventas = ventasService.getAll();
        return ResponseEntity.ok(ventas);
    }

    //                          Méthods             CRUD                          //

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<VentasEntity> create(@RequestBody VentasEntity venta) {
        VentasEntity createdVenta = ventasService.create(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVenta);
    }

    // UPDATE
    @PutMapping("/update/{idVenta}")
    public ResponseEntity<VentasEntity> update(@PathVariable int idVenta, @RequestBody VentasEntity venta) {
        VentasEntity updatedVenta = ventasService.update(idVenta, venta);
        if (updatedVenta != null) {
            return ResponseEntity.ok(updatedVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/delete/{idVenta}")
    public ResponseEntity<Void> deleteById(@PathVariable int idVenta) {
        ventasService.deleteById(idVenta);
        return ResponseEntity.noContent().build();
    }

    // READ
    @GetMapping("/read/{idVenta}")
    public ResponseEntity<VentasEntity> findById(@PathVariable int idVenta) {
        VentasEntity venta = ventasService.findById(idVenta);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
