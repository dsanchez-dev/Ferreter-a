package com.ferreteria.server;

import com.ferreteria.persistance.entity.VentasEntity;
import com.ferreteria.persistance.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    private final VentasRepository ventasRepository;

    @Autowired
    public VentasService(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    public List<VentasEntity> findAllByFecha(LocalDateTime fecha){
        return  ventasRepository.findAllByFecha(fecha);
    }


    //                  CRUD

    // CREATE
    public VentasEntity create(VentasEntity venta) {
        return ventasRepository.save(venta);
    }

    // READ
    public List<VentasEntity> getAll() {
        return ventasRepository.findAll();
    }

    public VentasEntity findById(int idVenta) {
        Optional<VentasEntity> ventaOptional = ventasRepository.findById(idVenta);
        return ventaOptional.orElse(null);
    }

    // UPDATE
    // UPDATE
    public VentasEntity update(int idVenta, VentasEntity venta) {
        venta.setIdVenta(idVenta); // Establecer el ID de la venta que se va a actualizar
        return ventasRepository.save(venta);
    }

    // DELETE
    public void deleteById(int idVenta) {
        ventasRepository.deleteById(idVenta);
    }

}
//s<>