package com.example.demo.model

import lombok.Data
@Data class ubicacion(
    val IDUbicacion:Int,
    val IDAlmacen:Int,
    val pasillo:Int,
    val nivel:Int,
    val estante:Int
)