package com.example.demo.repository

import com.example.demo.model.empleadosCliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioEmpleadosCliente:JpaRepository<empleadosCliente, String> {
    @Query("SELECT e FROM empleadosCliente e WHERE e.RFCEmpleador.RFC =:RFCEmpleador")
    fun findByRFCEmpleador(@Param("RFCEmpleador") RFCEmpleador: String): List<empleadosCliente>

    @Query("SELECT e FROM empleadosCliente e WHERE e.RFC =:RFC")
    fun findByRFC(@Param("RFC") RFC: String):empleadosCliente

    @Query("select c from empleadosCliente c where c.eliminado=false")
    fun findAllActive(): List<empleadosCliente>

    @Query("SELECT e FROM empleadosCliente e WHERE e.RFC = :RFC")
    fun findbyID(@Param("RFC")RFC: String):List<empleadosCliente>
}
