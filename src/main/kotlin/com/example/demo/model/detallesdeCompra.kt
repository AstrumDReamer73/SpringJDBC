package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity @Table(name="almacenes")data class detallesdeCompra(
    @Id val IDDetallesdeCompra:Int?=0,
    val factura:String?="",
    val UPC:Int?=0,
    val cantidad:Int?=0,
    val IVA:BigDecimal?= BigDecimal.ZERO,
    val IEPS:BigDecimal?= BigDecimal.ZERO,
    val Subtotal:BigDecimal?= BigDecimal.ZERO,
    val total:BigDecimal?= BigDecimal.ZERO
)