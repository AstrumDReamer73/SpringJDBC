package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "detallesdeCompras")
data class detallesdeCompra(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDDetalledeCompra: Int? = 0,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "factura") var factura: compra? = null, // Relación Many-to-One con `Compra`
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name="UPC")var articulo: articulo? = null,
    var cantidad: Int? = 0,
    var IVA: BigDecimal? = BigDecimal.ZERO,
    var IEPS: BigDecimal? = BigDecimal.ZERO,
    var Subtotal: BigDecimal? = BigDecimal.ZERO,
    var total: BigDecimal? = BigDecimal.ZERO,
)