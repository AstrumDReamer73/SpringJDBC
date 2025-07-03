package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity @Table(name="Clientes") data class cliente(
   @Id var RFC:String?="",
   var nombre:String?="",
   var direccion:String?="",
   var territorio:String?="",
   var estado:String?="",
   @Column(name="codPostal") var codPostal:String?="",
   var telefono:String?="",
   var correo:String?="",
   var fechadeAlta:LocalDateTime?=LocalDateTime.now(),
   var eliminado:Boolean?=false
)