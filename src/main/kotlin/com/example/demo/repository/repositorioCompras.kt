package com.example.demo.repository

import com.example.demo.model.compra
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface repositorioCompras : JpaRepository<compra, String> {
    @Query("select c from compra c where c.almacenDestino.IDAlmacen =: almacenDestino ")
    fun findByDestino(@Param("almacenDestino") almacenDestino:String): List<compra>

    @Query("select c from compra c where c.empleado.RFC=:empleado")
    fun findByEmployee(@Param("empleado") origen: String): List<compra>

    @Query("select c from compra c where c.proveedor.RFC=:proveedor ")
    fun findBySupplier(@Param("proveedor") proveedor: String): List<compra>

    @Query("SELECT c FROM compra c WHERE c.estado != 'cancelado' or c.estado!='eliminado'")
    fun findbyEliminadoFalse(): List<compra>

    @Query("select c from compra c where c.factura=:factura")
    fun findByFactura(@Param("factura") factura: String):compra

    @Query("select c from compra c where c.estado=:estado")
    fun findByestado(@Param("estado")estado:String): List<compra>

    @Query("select c from compra c order by c.fechayhora asc")
    fun findByfechayhoraAsc(): List<compra>

    @Query("select c from compra c order by c.fechayhora desc")
    fun findByfechayhoraDesc(): List<compra>
}
