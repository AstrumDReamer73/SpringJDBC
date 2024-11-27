package com.example.demo.model

import java.math.BigDecimal

import lombok.Data
@Data class categoria(
    val IDCategoria:Int=0,
    val nombre:String="",
    val IVA:BigDecimal=BigDecimal.ZERO,
    val IEPS:BigDecimal=BigDecimal.ZERO,
    val eliminado:Boolean=false
)