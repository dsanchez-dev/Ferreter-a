package com.ferreteria.server;

import com.ferreteria.persistance.entity.DetallesVentaEntity;
import com.ferreteria.persistance.repository.DetallesVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetallesVentaService {
    private final DetallesVentaRepository detallesVentaRepository;

    @Autowired
    public DetallesVentaService(DetallesVentaRepository detallesVentaRepository) {
        this.detallesVentaRepository = detallesVentaRepository;
    }

    public DetallesVentaEntity findById(int IdDetallesVenta){
        return detallesVentaRepository.findById(IdDetallesVenta).orElse(null);
    }

    public DetallesVentaEntity save(DetallesVentaEntity detallesVenta){
        return detallesVentaRepository.save(detallesVenta);
    }

    public void deleteById(int IdDetallesVenta){
        detallesVentaRepository.deleteById(IdDetallesVenta);
    }

    public boolean IfExistDetallesVentaById(int idDetallesVenta){
        Optional<DetallesVentaEntity> detallesVenta = detallesVentaRepository.findById(idDetallesVenta);
        return detallesVenta.isPresent();
    }
}
//s<>