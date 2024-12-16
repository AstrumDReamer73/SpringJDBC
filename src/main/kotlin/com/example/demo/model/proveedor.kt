package com.example.demo.model;

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data;
import java.time.LocalDateTime
import java.util.*

@Entity @Table(name="proveedores") data class proveedor(
        @Id var RFC:String?="",
        var nombre:String?="",
        var direccion:String?="",
        var territorio:String?="",
        var estado:String?="",
        var codPostal:String?="",
        var telefono:String?="",
        var correo:String?="",
        var fechadeAlta: LocalDateTime?=LocalDateTime.now(),
        var eliminado:Boolean?=false
)
