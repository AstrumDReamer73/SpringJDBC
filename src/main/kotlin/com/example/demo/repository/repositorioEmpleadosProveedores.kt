package com.example.demo.repository

import com.example.demo.model.articulo
import com.example.demo.model.categoria
import com.example.demo.model.empleadosProveedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface repositorioEmpleadosProveedores : JpaRepository<empleadosProveedor, String> {
    @Query("SELECT e FROM empleadosProveedor e WHERE e.RFCEmpleador.RFC = :RFCEmpleador")
    fun findByRFCEmpleador(@Param("RFCEmpleador")RFCEmpleador: String): List<empleadosProveedor>

    @Query("select c from empleadosProveedor c where c.eliminado=false")
    fun findAllActive(): List<empleadosProveedor>

    @Query("SELECT e FROM empleadosProveedor e WHERE e.RFC = :RFC")
    fun findbyID(@Param("RFC")RFC: String):empleadosProveedor
}
