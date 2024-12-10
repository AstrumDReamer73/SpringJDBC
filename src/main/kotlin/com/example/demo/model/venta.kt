package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity @Table(name="ventas")data class venta(
    @Id var factura:String="",
    @ManyToOne @JoinColumn(name = "RFCCliente") var cliente: cliente? = null,
    var motivo:String?="",
    @OneToOne @JoinColumn(name="almacenOrigen") var almacenOrigen:almacen?=null,
    var destino:String?="",
    var empleado: String?="",
    var fechayhora: LocalDateTime?=null,
    var tipo:String?="",
    var estado:String?="",
    @OneToMany (mappedBy = "factura",cascade = [CascadeType.ALL], orphanRemoval = true) var detalles: MutableList<detallesdeVenta> = mutableListOf(),
)