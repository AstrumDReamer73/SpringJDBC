package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity @Table(name="ventas")data class venta(
    @Id val factura:String?="",
    val motivo:String?="",
    val origen:Int?=0,
    val destino:String?="",
    val empleado: String?="",
    val fechayhora: LocalDateTime?=null,
    val tipo:String?="",
    val estado:String?=""
)