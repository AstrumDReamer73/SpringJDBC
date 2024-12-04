package com.example.demo.repository

import com.example.demo.model.proveedor
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository interface repositorioProveedores : JpaRepository<proveedor, String> {
    fun findByEliminadoFalse(): List<proveedor>
}
