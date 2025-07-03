package com.example.demo.repository

import com.example.demo.model.venta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioVentas : JpaRepository<venta, String> {
    @Query("SELECT v FROM venta v WHERE v.estado != 'cancelado' or v.estado!='eliminado'")
    fun findByEliminadoFalse(): List<venta>

    @Query("select v from venta v where v.almacenOrigen=:almacenOrigen")
    fun findByOrigen(@Param("almacenOrigen") almacenOrigen:String?):List<venta>

    @Query("select v from venta v where v.empleado=:empleado")
    fun findByEmployee(@Param("empleado") origen: String?): List<venta>

    @Query("select v from venta v where v.cliente.RFC=:cliente")
    fun findByCustomer(@Param("cliente") cliente: String?):List<venta>

    @Query("select v from venta v where v.estado=:estado")
    fun findByEstado(@Param("estado") estado: String?):List<venta>

    @Query("select v from venta v where v.factura=:factura")
    fun findByFactura(@Param("factura") factura: String?):venta

    @Query("select c from venta c order by c.fechayhora asc")
    fun findByfechayhoraAsc(): List<venta>

    @Query("select c from venta c order by c.fechayhora desc")
    fun findByfechayhoraDesc(): List<venta>
}