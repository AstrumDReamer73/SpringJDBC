package com.example.demo.repository

import com.example.demo.model.traslado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioTraslados:JpaRepository<traslado,Int> {
    @Query("SELECT d FROM traslado d WHERE d.estado != 'cancelado' or d.estado!='eliminado'")
    fun findByEliminadoFalse(): List<traslado>

    @Query("select d from traslado d where d.almacenOrigen=:almacenOrigen")
    fun findByOrigen(@Param("almacenOrigen")almacenOrigen:String):List<traslado>

    @Query("select d from traslado d where d.almacenDestino=:almacenDestino")
    fun findByDestino(@Param("almacenDestino")almacenDestino:String):List<traslado>

    @Query("select d from traslado d where d.IDTraslado=:IDTraslado")
    fun findbyID(@Param("IDTraslado")IDTraslado:Int):traslado
}