package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import java.util.*

@Entity @Table(name="empleadosProveedores") data class empleadosProveedor(
    @Id val RFC:String?="",
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