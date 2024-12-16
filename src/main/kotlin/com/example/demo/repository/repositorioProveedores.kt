package com.example.demo.repository

import com.example.demo.model.categoria
import com.example.demo.model.proveedor
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

@Repository interface repositorioProveedores : JpaRepository<proveedor, String> {
    @Query("select c from proveedor c where c.eliminado=false")
    fun findAllActive(): List<proveedor>

    @Query("select p from proveedor p where p.RFC=:RFC")
    fun findbyRFC(@Param("RFC")RFC:String):proveedor
}
