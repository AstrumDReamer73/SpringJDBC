package com.example.demo.repository

import com.example.demo.model.articulo
import com.example.demo.model.categoria
import com.example.demo.model.ubicacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioUbicaciones: JpaRepository<ubicacion, Int> {
    @Query("select c from ubicacion c where c.eliminado=false")
    fun findAllActive(): List<ubicacion>

    @Query("select u from ubicacion u where IDUbicacion=:IDUbicacion")
    fun findbyIDUbicacion(@Param("IDUbicacion") int: Int):ubicacion
}