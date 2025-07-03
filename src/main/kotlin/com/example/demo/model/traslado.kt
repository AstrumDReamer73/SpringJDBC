package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity @Table(name = "traslados") data class traslado(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDTraslado: Int? = 0,
    @OneToOne @JoinColumn(name = "IDAlmacenOrigen") var almacenOrigen: almacen?=null,
    @OneToOne @JoinColumn(name = "IDAlmacenDestino") var almacenDestino: almacen?=null,
    var fechayhora: LocalDateTime? = LocalDateTime.now(),
    var estado: String? = "",
    var Subtotal: BigDecimal?= BigDecimal.ZERO,
    var total: BigDecimal?= BigDecimal.ZERO
)