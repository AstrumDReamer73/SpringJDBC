package com.example.demo.model

import java.util.*

import lombok.Data
import java.time.LocalDateTime

@Data class compras(
    val factura:String,
    val motivo:String,
    val origen:Int,
    val destino:String,
    val empleado: String,
    val fechayhora: LocalDateTime,
    val tipo:String,
    val estado:String
)