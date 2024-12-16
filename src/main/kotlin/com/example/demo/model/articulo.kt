package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Date

@Entity @Table(name="articulos") data class articulo(
    @Id var upc:Int?=0,
    @OneToOne @JoinColumn(name="idposicion") var ubicacion:ubicacion?=null,
    var descripcion:String?="",
    var cantidad:Int?=0,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="idcategoria") var categoria:categoria?=null,
    var costoCompra:BigDecimal?= BigDecimal.ZERO,
    var ultimoCostoCompra:BigDecimal?= BigDecimal.ZERO,
    var precioVenta:BigDecimal?= BigDecimal.ZERO,
    var ultimoPrecioVenta:BigDecimal?= BigDecimal.ZERO,
    var ultimaFechaModificacion:LocalDateTime?=LocalDateTime.now(),
    var eliminado:Boolean?=false
)