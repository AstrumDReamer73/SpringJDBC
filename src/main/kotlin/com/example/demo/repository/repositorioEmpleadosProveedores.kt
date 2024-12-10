package com.example.demo.repository

import com.example.demo.model.empleadosProveedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface repositorioEmpleadosProveedores : JpaRepository<empleadosProveedor, String> {
    @Query("SELECT e FROM empleadosProveedor e WHERE e.RFCEmpleador = :RFCEmpleador")
    fun findByRFCEmpleador(@Param("RFCEmpleador")RFCEmpleador: String): List<empleadosProveedor>
    fun findByEliminadoFalse(): List<empleadosProveedor>
}
