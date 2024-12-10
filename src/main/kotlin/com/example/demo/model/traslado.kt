package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "traslados")
data class traslado(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDTraslado: Int = 0,
    @OneToOne @JoinColumn(name = "IDAlmacenOrigen") var almacenOrigen: almacen, // Relación One-to-One con `Almacen`
    @OneToOne @JoinColumn(name = "IDAlmacenDestino") var almacenDestino: almacen, // Relación One-to-One con `Almacen
    var fechayhora: LocalDateTime? = null,
    var estado: String? = "",
   // @OneToMany (mappedBy = "IDTraslado", cascade = [CascadeType.ALL], orphanRemoval = true) var detalles: MutableList<detallesTraslado> = mutableListOf(),
)