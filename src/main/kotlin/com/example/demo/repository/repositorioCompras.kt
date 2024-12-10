package com.example.demo.repository

import com.example.demo.model.compra
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
interface repositorioCompras : JpaRepository<compra, String> {
    @Query("select c from compra c where c.almacenDestino =: almacenDestino ")
    fun findPurchasesByDestino(@Param("almacenDestino") almacenDestino:String): List<compra>

    @Query("select c from compra c where c.empleado =: empleado")
    fun findPurchasesByEmployee(@Param("empleado") origen: String): List<compra>

    @Query("select c from compra c where c.proveedor =: proveedor ")
    fun findPurchasesBySupplier(@Param("proveedor") proveedor: String): List<compra>

    @Query("SELECT c FROM compra c WHERE c.estado != 'cancelado' or c.estado!='eliminado'")
    fun findbyEliminadoFalse(): List<compra>
}
