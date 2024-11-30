package com.example.demo.model

import java.math.BigDecimal
import lombok.Data
@Data class detallesdeVenta (
    val IDDetallesdeCompra:Int?=0,
    val factura:String?="",
    val UPC:Int?=0,
    val cantidad:Int?=0,
    val IVA: BigDecimal?= BigDecimal.ZERO,
    val IEPS: BigDecimal?= BigDecimal.ZERO,
    val Subtotal: BigDecimal?= BigDecimal.ZERO,
    val total: BigDecimal?= BigDecimal.ZERO
)