package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import java.time.LocalDateTime
import java.util.*

@Entity @Table(name="almacenes")data class compra(
    @Id val factura:String?="",
    val motivo:String?="",
    val origen:Int?=0,
    val destino:String?="",
    val empleado: String?="",
    val fechayhora: LocalDateTime?= null,
    val tipo:String="",
    val estado:String=""
)