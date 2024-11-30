package com.example.demo.model

import lombok.Data
import java.time.LocalDateTime
import java.util.*

@Data class compra(
    val factura:String?="",
    val motivo:String?="",
    val origen:Int?=0,
    val destino:String?="",
    val empleado: String?="",
    val fechayhora: LocalDateTime?= null,
    val tipo:String="",
    val estado:String=""
)