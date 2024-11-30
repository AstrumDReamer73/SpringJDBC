package com.example.demo.model
import java.math.BigDecimal
import java.util.Date
import lombok.Data
@Data class articulos(
    val UPC:Int=0,
    val posicion:Int=0,
    val descripcion:String="",
    val cantidad:Int=0,
    val categoria:Int=0,
    val costoCompra:BigDecimal= BigDecimal.ZERO,
    val ultimoCostoCompra:BigDecimal= BigDecimal.ZERO,
    val precioVenta:BigDecimal= BigDecimal.ZERO,
    val ultimoPrecioVenta:BigDecimal= BigDecimal.ZERO,
    val ultimaFechaModificacion:Date=Date(),
    val eliminado:Boolean=false
)