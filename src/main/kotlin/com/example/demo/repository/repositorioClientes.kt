package com.example.demo.repository

import com.example.demo.model.cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface repositorioClientes: JpaRepository<cliente, String> {
    fun findByEliminadoFalse(): List<cliente>
}