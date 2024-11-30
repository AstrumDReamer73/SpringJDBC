package com.example.demo.repository

import com.example.demo.model.venta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioVentas @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<venta> {
        val sql = "SELECT * FROM ventas"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(venta::class.java))
    }

    fun findAllActive(): List<venta> {
        val sql = "SELECT * FROM ventas where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(venta::class.java))
    }

    fun save(venta: venta): Int {
        val sql = "INSERT INTO ventas VALUES (?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, venta.factura,venta.motivo, venta.origen, venta.destino, venta.empleado, venta.fechayhora,venta.tipo,venta.estado)
    }

    fun update(venta: venta): Int {
        val sql = "UPDATE ventas SET motivo=?, origen=?, destino=?, empleado=?, fechayhora=?, tipo=?, estado=? WHERE factura=?"
        return jdbcTemplate.update(sql,venta.factura,venta.motivo, venta.origen, venta.destino, venta.empleado, venta.fechayhora,venta.tipo,venta.estado)
    }

    fun deleteByFactura(factura:String): Int {
        val sql = "update ventas set estado=? where factura=? "
        return jdbcTemplate.update(sql, factura)
    }
}