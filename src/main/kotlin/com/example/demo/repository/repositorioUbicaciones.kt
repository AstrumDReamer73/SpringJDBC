package com.example.demo.repository

import com.example.demo.model.ubicacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface repositorioUbicaciones: JpaRepository<ubicacion, Int> {
    fun findByEliminado(eliminado: Boolean): List<ubicacion>
}