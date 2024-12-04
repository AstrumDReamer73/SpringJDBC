package com.example.demo.repository

import com.example.demo.model.almacen
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository interface repositorioAlmacenes : JpaRepository<almacen, Int> {
    fun findByEliminadoFalse(): List<almacen>
}
