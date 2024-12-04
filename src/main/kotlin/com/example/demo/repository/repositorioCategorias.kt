package com.example.demo.repository

import com.example.demo.model.categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface repositorioCategorias : JpaRepository<categoria, Int> {
    fun findByEliminado(eliminado: Boolean): List<categoria>
}