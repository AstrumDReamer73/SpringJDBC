package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.Date

@Entity @Table(name="almacenes") data class articulo(
    @Id val UPC:Int=0,
    @OneToOne @JoinColumn(name="IDPosicion") val posicion:ubicacion?=null,
    val descripcion:String="",
    val cantidad:Int=0,
    @OneToOne @JoinColumn(name="IDCategoria") val categoria:categoria?=null,
    val costoCompra:BigDecimal= BigDecimal.ZERO,
    val ultimoCostoCompra:BigDecimal= BigDecimal.ZERO,
    val precioVenta:BigDecimal= BigDecimal.ZERO,
    val ultimoPrecioVenta:BigDecimal= BigDecimal.ZERO,
    val ultimaFechaModificacion:Date=Date(),
    val eliminado:Boolean=false
)