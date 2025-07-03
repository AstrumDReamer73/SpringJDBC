package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity @Table(name="empleadosProveedores") data class empleadosProveedor(
    @Id var RFC:String?="",
    @ManyToOne @JoinColumn(name="RFCEmpleador") var RFCEmpleador:proveedor?=null,
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