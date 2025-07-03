package com.example.demo.model

import jakarta.persistence.*

@Entity @Table(name = "Ubicaciones") data class ubicacion(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDUbicacion: Int? = 0,
    @ManyToOne @JoinColumn(name = "IDAlmacen", nullable = false) var IDAlmacen: almacen?=null,
    var pasillo: Int? = 0,
    var nivel: Int? = 0,
    var estante: Int? = 0
)
