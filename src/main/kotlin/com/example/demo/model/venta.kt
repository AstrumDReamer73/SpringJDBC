package com.example.demo.model

import lombok.Data
import java.time.LocalDateTime

@Data class venta(
    val factura:String?="",
    val motivo:String?="",
    val origen:Int?=0,
    val destino:String?="",
    val empleado: String?="",
    val fechayhora: LocalDateTime?=null,
    val tipo:String?="",
    val estado:String?=""
)