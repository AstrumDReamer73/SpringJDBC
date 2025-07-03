package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity @Table(name="empleadosClientes")data class empleadosCliente(
    @Id var RFC:String="",
    @ManyToOne @JoinColumn(name="RFCCliente") var RFCEmpleador:cliente?=null,
    var nombre:String?="",
    var direccion:String?="",
    var territorio:String?="",
    var estado:String?="",
    @Column(name="codPostal") var codPostal:String?="",
    var telefono:String?="",
    var correo:String?="",
    var fechaAlta: LocalDateTime?=LocalDateTime.now(),
    var eliminado:Boolean?=false
)