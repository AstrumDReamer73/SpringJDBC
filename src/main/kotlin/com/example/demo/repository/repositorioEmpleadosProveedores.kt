package com.example.demo.repository

import com.example.demo.model.empleadosProveedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface repositorioEmpleadosProveedores : JpaRepository<empleadosProveedor, String> {
    fun findByRfcEmpleador(rfcEmpleador: String): List<empleadosProveedor>
    fun findByEliminadoFalse(): List<empleadosProveedor>
}
