package com.example.demo.repository

import com.example.demo.model.empleadosCliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioEmpleadosCliente:JpaRepository<empleadosCliente, String> {
    @Query("SELECT e FROM empleadosCliente e WHERE e.RFCEmpleador = :RFCEmpleador")
    fun findByRFCEmpleador(@Param("RFCEmpleador") RFCEmpleador: String): List<empleadosCliente>

    fun findByEliminadoFalse():List<empleadosCliente>
}
