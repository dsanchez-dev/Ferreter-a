package com.ferreteria.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detalles_venta")
public class DetallesVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_detalle", nullable = false)
    private Integer idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_venta")
    private VentasEntity venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_producto")
    private ProductosEntity producto;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "Subtotal")
    private Double subtotal;
}
