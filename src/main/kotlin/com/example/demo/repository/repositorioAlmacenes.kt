package com.example.demo.repository

import com.example.demo.model.almacen
import com.example.demo.model.articulo
import com.example.demo.model.categoria
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

@Repository interface repositorioAlmacenes : JpaRepository<almacen, Int> {
    @Query("select c from almacen c where c.eliminado=false")
    fun findAllActive(): List<almacen>

    @Query("select a from almacen a where a.IDAlmacen=:id")
    fun findbyIDAlmacen(@Param("id") id: Int):almacen
}
