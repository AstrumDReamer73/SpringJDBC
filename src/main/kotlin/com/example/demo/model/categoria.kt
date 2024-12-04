package com.example.demo.model
import jakarta.persistence.*
import java.math.BigDecimal

@Entity @Table(name="almacenes") data class categoria(
    @Id val IDCategoria:Int=0,
    val nombre:String="",
    val IVA:BigDecimal=BigDecimal.ZERO,
    val IEPS:BigDecimal=BigDecimal.ZERO,
    val eliminado:Boolean=false
)