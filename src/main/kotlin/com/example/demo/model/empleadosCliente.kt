package com.example.demo.model

import lombok.Data
import java.util.*

@Data class empleadosCliente(
    val RFC:String?="",
    val RFCEmpleador:String?="",
    val nombre:String?="",
    val direccion:String?="",
    val territorio:String?="",
    val estado:String?="",
    val codPostal:String?="",
    val telefono:String?="",
    val correo:String?="",
    val fechaAlta: Date?=Date(),
    val eliminado:Boolean?=false
)