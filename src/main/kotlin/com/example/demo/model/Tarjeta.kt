package com.example.demo.model

import lombok.Data

@Data data class Tarjeta(
    val IDTarjeta:String,
    val nombre:String,
    val numero:String,
    val tipo:String,
    val cvv:Int,
    val status:Int
)