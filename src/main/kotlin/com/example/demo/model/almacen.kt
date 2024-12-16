package com.example.demo.model

import jakarta.persistence.*

@Entity @Table(name = "almacenes") data class almacen(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDAlmacen: Int = 0,
    var nombre: String? = "",
    var direccion: String? = "",
    var territorio: String? = "",
    var estado: String? = "",
    var codPostal: String? = "",
    var telefono: String? = "",
    var capacidad: Int? = 0,
    var puertos: Int? = 0,
    var refrigeracion: Boolean? = false,
    var eliminado: Boolean = false
)