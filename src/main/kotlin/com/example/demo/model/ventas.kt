package com.example.demo.model

import lombok.Data
import java.time.LocalDateTime

@Data class ventas(
    val factura:String,
    val motivo:String,
    val origen:Int,
    val destino:String,
    val empleado: String,
    val fechayhora: LocalDateTime,
    val tipo:String,
    val estado:String
)