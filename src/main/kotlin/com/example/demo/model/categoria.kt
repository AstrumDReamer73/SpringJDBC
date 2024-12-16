package com.example.demo.model
import jakarta.persistence.*
import java.math.BigDecimal

@Entity @Table(name = "categorias") data class categoria(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var IDCategoria: Int? = 0,
    var nombre: String? = "",
    var IVA: BigDecimal? = BigDecimal.ZERO,
    var IEPS: BigDecimal? = BigDecimal.ZERO,
    var eliminado: Boolean? = false
)