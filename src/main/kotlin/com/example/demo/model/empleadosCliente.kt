package com.example.demo.model

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity @Table(name="empleadosClientes")data class empleadosCliente(
    @Id var RFC:String="",
    @ManyToOne @JoinColumn(name="RFCEmpleador") var RFCEmpleador:cliente?=null,
    var nombre:String?="",
    var direccion:String?="",
    var territorio:String?="",
    var estado:String?="",
    var codPostal:String?="",
    var telefono:String?="",
    var correo:String?="",
    var fechaAlta: Date?=Date(),
    var eliminado:Boolean?=false
)