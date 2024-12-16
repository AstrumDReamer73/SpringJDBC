package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity @Table(name="empleados_Proveedores") data class empleadosProveedor(
    @Id var RFC:String?="",
    @ManyToOne @JoinColumn(name="RFCEmpleador") var RFCEmpleador:proveedor?=null,
    var nombre:String?="",
    var direccion:String?="",
    var territorio:String?="",
    var estado:String?="",
    var codPostal:String?="",
    var telefono:String?="",
    var correo:String?="",
    var fechaAlta: LocalDateTime?=LocalDateTime.now(),
    var eliminado:Boolean?=false
)