package com.example.demo.repository

import com.example.demo.model.categoria
import com.example.demo.model.cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioClientes: JpaRepository<cliente, String> {
    @Query("select c from cliente c where c.eliminado=false")
    fun findAllActive(): List<cliente>

    @Query("select c from cliente c where c.RFC=:RFC")
    fun findbyRFC(@Param("RFC") RFC:String):cliente
}