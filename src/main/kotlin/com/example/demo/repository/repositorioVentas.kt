package com.example.demo.repository

import com.example.demo.model.ventas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioVentas @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<ventas> {
        val sql = "SELECT * FROM ventas"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(ventas::class.java))
    }

    fun findAllActive(): List<ventas> {
        val sql = "SELECT * FROM ventas where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(ventas::class.java))
    }

    fun save(ventas: ventas): Int {
        val sql = "INSERT INTO ventas VALUES (?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, ventas.factura,ventas.motivo, ventas.origen, ventas.destino, ventas.empleado, ventas.fechayhora,ventas.tipo,ventas.estado)
    }

    fun update(ventas: ventas): Int {
        val sql = "UPDATE ventas SET motivo=?, origen=?, destino=?, empleado=?, fechayhora=?, tipo=?, estado=? WHERE factura=?"
        return jdbcTemplate.update(sql,ventas.factura,ventas.motivo, ventas.origen, ventas.destino, ventas.empleado, ventas.fechayhora,ventas.tipo,ventas.estado)
    }

    fun deleteByFactura(factura:String): Int {
        val sql = "update ventas set estado=? where factura=? "
        return jdbcTemplate.update(sql, factura)
    }
}