package com.example.demo.repository

import com.example.demo.model.articulo
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface repositorioArticulos : JpaRepository<articulo, Int> {
    fun findByEliminadoAndUPC(eliminado: Boolean, UPC: Int): List<articulo>
}
