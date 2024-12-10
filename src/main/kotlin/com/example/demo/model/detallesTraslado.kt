package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity @Table(name="detallesTraslados")data class detallesTraslado (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDDetallesTraslado:Int?=0,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "IDTraslado") var IDTraslado: traslado,
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name="UPC")var articulo: articulo? = null,
    var categoría:Int,
    var cantidad:Int,
    var IVA: BigDecimal? = BigDecimal.ZERO,
    var IEPS:BigDecimal? = BigDecimal.ZERO,
    var subtotal:BigDecimal? = BigDecimal.ZERO,
    var total:BigDecimal? = BigDecimal.ZERO
)

