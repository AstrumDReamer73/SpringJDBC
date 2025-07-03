package com.example.demo.repository

import com.example.demo.model.almacen
import com.example.demo.model.ubicacion
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioUbicaciones: JpaRepository<ubicacion, Int> {
    @Query("select u from ubicacion u")
    fun findAllActive(): List<ubicacion>

    @Query("select u from ubicacion u where IDUbicacion=:IDUbicacion")
    fun findbyIDUbicacion(@Param("IDUbicacion") int: Int):ubicacion

    @Transactional @Modifying
    @Query("DELETE FROM ubicacion u WHERE u.IDUbicacion = id")
    fun deleteByID(@Param("id") id: Int): Int
}