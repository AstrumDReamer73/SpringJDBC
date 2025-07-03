package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity @Table(name="Articulos") data class articulo(
    @Id var UPC:Int?=0,
    var descripcion:String?="",
    var cantidad:Int?=0,
    @OneToOne @JoinColumn(name="idposicion") var ubicacion:ubicacion?=null,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="idcategoria") var categoria:categoria?=null,
    var costoCompra:BigDecimal?= BigDecimal.ZERO,
    var ultimoCostoCompra:BigDecimal?= BigDecimal.ZERO,
    var precioVenta:BigDecimal?= BigDecimal.ZERO,
    var ultimoPrecioVenta:BigDecimal?= BigDecimal.ZERO,
    var ultimaFechaModificacion:LocalDateTime?=LocalDateTime.now(),
    var eliminado:Boolean?=false
)