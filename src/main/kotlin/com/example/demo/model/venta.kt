package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity @Table(name="ventas")data class venta(
    @Id var factura:String?="",
    @ManyToOne @JoinColumn(name = "RFCCliente") var cliente: cliente? = null,
    @OneToOne @JoinColumn(name="almacenOrigen") var almacenOrigen:almacen?=null,
    @ManyToOne @JoinColumn(name="rfcempleado")var empleado: empleadosCliente? = null,
    var destino:String?="",
    var tipo:String?="",
    var motivo:String?="",
    var estado:String?="",
    var total:BigDecimal?=BigDecimal.ZERO,
    var fechayhora: LocalDateTime?=LocalDateTime.now()
)