package com.example.demo.model

import lombok.Data

@Data
class almacen(
    val IDAlmacen:Int,
    val nombre:String,
    val direccion:String,
    val territorio:String,
    val estado:String,
    val codPostal:String,
    val telefono:String,
    val capacidad:Int,
    val puertos:Int,
    val refrigeracion:Boolean,
    val eliminado:Boolean
)