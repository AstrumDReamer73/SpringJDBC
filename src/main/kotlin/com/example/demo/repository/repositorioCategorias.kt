package com.example.demo.repository

import com.example.demo.model.categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioCategorias : JpaRepository<categoria, Int> {
    @Query("select c from categoria c where c.eliminado=false")
    fun findAllActive(): List<categoria>

    @Query("select c from categoria c where c.IDCategoria=:id")
    fun findbyID(@Param("id") int: Int):categoria
}