package com.ferreteria.web.controller;

import com.ferreteria.persistance.entity.DetallesVentaEntity;
import com.ferreteria.server.DetallesVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detallesVenta")
public class DetallesVentaController {
    private final DetallesVentaService detallesVentaService;

    @Autowired
    public DetallesVentaController(DetallesVentaService detallesVentaService) {
        this.detallesVentaService = detallesVentaService;
    }

    //                          Méthods             CRUD                          //

    @PostMapping("/crear")
    public ResponseEntity<DetallesVentaEntity> crearDetallesVenta(@RequestBody DetallesVentaEntity detallesVenta){
        try {
            // Guardar el nuevo detalle de venta en la base de datos
            DetallesVentaEntity nuevoDetalleVenta = detallesVentaService.save(detallesVenta);
            // Devolver una respuesta exitosa con el nuevo detalle de venta creado
            return ResponseEntity.status(HttpStatus.CREATED).body( nuevoDetalleVenta);
        }catch (Exception e){
            // En caso de error, devolver una respuesta de error 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/read/{idDetallesVenta}")
    public ResponseEntity<DetallesVentaEntity> getById(@PathVariable int idDetallesVenta){
        DetallesVentaEntity detallesVenta = this.detallesVentaService.findById(idDetallesVenta);
        if (detallesVenta != null){
            return ResponseEntity.ok(detallesVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar/{idDetallesVenta}")
    public ResponseEntity<DetallesVentaEntity> updateDetallesVenta(@PathVariable int idDetallesVenta, @RequestBody DetallesVentaEntity detallesVenta) {
        boolean existeDetalleVenta = detallesVentaService.IfExistDetallesVentaById(idDetallesVenta);

        if (existeDetalleVenta) {
            // Si el ID coincide con el detalle de venta existente
            detallesVenta.setIdDetalle(idDetallesVenta);
            DetallesVentaEntity detalleVentaActualizado = detallesVentaService.save(detallesVenta);
            return ResponseEntity.ok(detalleVentaActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{idDetalleVenta}")
    public ResponseEntity<Void> deleteDetallesVenta(@PathVariable int idDetalleVenta){
        boolean existeDetalleVenta = detallesVentaService.IfExistDetallesVentaById(idDetalleVenta);
        if (existeDetalleVenta){
            detallesVentaService.deleteById(idDetalleVenta);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
//s<>