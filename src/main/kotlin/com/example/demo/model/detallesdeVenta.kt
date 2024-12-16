package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal
@Entity @Table(name="detallesdeVentas")data class detallesdeVenta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDDetalledeVenta: Int? = 0,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "factura") var factura: venta? = null,
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name="UPC")var articulo: articulo? = null,
    var categoria: Int?=0,
    var cantidad: Int? = 0,
    var IVA: BigDecimal? = BigDecimal.ZERO,
    var IEPS: BigDecimal? = BigDecimal.ZERO,
    var Subtotal: BigDecimal? = BigDecimal.ZERO,
    var total: BigDecimal? = BigDecimal.ZERO
)