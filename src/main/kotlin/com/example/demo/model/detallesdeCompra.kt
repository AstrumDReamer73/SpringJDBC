package com.example.demo.model

import java.math.BigDecimal

import lombok.Data
@Data class detallesdeCompra(
    val IDDetallesdeCompra:Int,
    val factura:String,
    val UPC:Int,
    val cantidad:Int,
    val IVA:BigDecimal,
    val IEPS:BigDecimal,
    val Subtotal:BigDecimal,
    val total:BigDecimal
)