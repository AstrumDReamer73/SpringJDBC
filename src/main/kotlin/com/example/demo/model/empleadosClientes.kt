package com.example.demo.model

import lombok.Data
import java.util.*

@Data class empleadosClientes(
    val RFC:String,
    val RFCEmpleador:String,
    val nombre:String,
    val direccion:String,
    val territorio:String,
    val estado:String,
    val codPostal:String,
    val telefono:String,
    val correo:String,
    val fechaAlta: Date,
    val eliminado:Boolean
)