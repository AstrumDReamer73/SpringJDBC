package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity @Table(name="detallesVentas")data class detallesVenta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDDetalledeVenta: Int? = 0,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "factura") var factura: venta? = null,
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name="UPC")var articulo: articulo? = null,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "categoria") var categoria: categoria? = null,
    var cantidad: Int? = 0,
    var IVA: BigDecimal? = BigDecimal.ZERO,
    var IEPS: BigDecimal? = BigDecimal.ZERO,
    var Subtotal: BigDecimal? = BigDecimal.ZERO,
    var total: BigDecimal? = BigDecimal.ZERO
)