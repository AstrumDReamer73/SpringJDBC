package com.example.demo.repository

import com.example.demo.model.articulo
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

@Repository interface repositorioArticulos : JpaRepository<articulo, Int> {
    @Query("SELECT a FROM articulo a WHERE a.UPC = :UPC")
    fun findbyUPC(@Param("UPC") upc: Int): articulo

    @Query("select a from articulo a where a.categoria=:categoria")
    fun findByCategoria(@Param("categoria")categoria: Int):List<articulo>

    @Query("select c from articulo c where c.eliminado=false")
    fun findAllActive(): List<articulo>
}
