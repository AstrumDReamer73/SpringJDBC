package com.example.demo.model

import jakarta.persistence.*

@Entity @Table(name="ubicaciones")data class ubicacion(
    @Id val IDUbicacion:Int?=0,
    val IDAlmacen:Int?=0,
    val pasillo:Int?=0,
    val nivel:Int?=0,
    val estante:Int?=0
)