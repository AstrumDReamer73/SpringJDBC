package com.example.demo.repository

import com.example.demo.model.cliente
import com.example.demo.model.empleadosCliente
import com.example.demo.model.venta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioClientes @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {
    fun findAll(): List<cliente> {
        val sql = "SELECT * FROM clientes"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(cliente::class.java))
    }

    fun findAllActive(): List<cliente> {
        val sql = "SELECT * FROM clientes where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(cliente::class.java))
    }

    fun findAllEmpleados(RFC: String):List<empleadosCliente>{
        val sql = "SELECT * FROM empleadosClientes WHERE rfcEmpleador=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosCliente::class.java))
    }

    fun findAllSells(RFC: String):List<venta>{
        val sql = "SELECT * FROM ventas WHERE destino=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(venta::class.java))
    }

    fun save(cliente: cliente): Int {
        val sql = "INSERT INTO clientes VALUES (?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, cliente.RFC, cliente.nombre, cliente.direccion, cliente.territorio, cliente.estado, cliente.codPostal, cliente.telefono, cliente.correo, cliente.fechaAlta, cliente.eliminado)
    }

    fun update(cliente: cliente): Int {
        val sql = "UPDATE clientes SET RFC=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  cliente.RFC, cliente.nombre, cliente.direccion, cliente.territorio, cliente.estado, cliente.codPostal, cliente.telefono, cliente.correo, cliente.fechaAlta ,cliente.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE clientes SET eliminado=? WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql, rfc)
    }
}