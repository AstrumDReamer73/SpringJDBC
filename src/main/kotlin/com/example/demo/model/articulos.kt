package com.example.demo.model

import java.math.BigDecimal
import java.util.Date

import lombok.Data
@Data class articulos(
    val UPC:Int,
    val posicion:Int,
    val descripcion:String,
    val cantidad:Int,
    val categoria:Int,
    val costoCompra:BigDecimal,
    val ultimoCostoCompra:BigDecimal,
    val precioVenta:BigDecimal,
    val ultimoPrecioVenta:BigDecimal,
    val ultimaFechaModificacion:Date,
    val eliminado:Boolean
)