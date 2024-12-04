package com.example.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity @Table(name="almacenes") data class almacen(
    @Id val IDAlmacen:Int?=0,
    val nombre:String?="",
    val direccion:String?="",
    val territorio:String?="",
    val estado:String?="",
    val codPostal:String?="",
    val telefono:String?="",
    val capacidad:Int?=0,
    val puertos:Int?=0,
    val refrigeracion:Boolean?=false,
    val eliminado:Boolean=false
)