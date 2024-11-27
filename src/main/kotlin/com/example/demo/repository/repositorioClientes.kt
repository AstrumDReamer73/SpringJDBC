package com.example.demo.repository

import com.example.demo.model.clientes
import com.example.demo.model.empleadosClientes
import com.example.demo.model.ventas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioClientes @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {
    fun findAll(): List<clientes> {
        val sql = "SELECT * FROM clientes"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(clientes::class.java))
    }

    fun findAllActive(): List<clientes> {
        val sql = "SELECT * FROM clientes where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(clientes::class.java))
    }

    fun findAllEmpleados(RFC: String):List<empleadosClientes>{
        val sql = "SELECT * FROM empleadosClientes WHERE rfcEmpleador=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosClientes::class.java))
    }

    fun findAllSells(RFC: String):List<ventas>{
        val sql = "SELECT * FROM ventas WHERE destino=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(ventas::class.java))
    }

    fun save(clientes: clientes): Int {
        val sql = "INSERT INTO clientes VALUES (?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, clientes.RFC, clientes.nombre, clientes.direccion, clientes.territorio, clientes.estado, clientes.codPostal, clientes.telefono, clientes.correo, clientes.fechaAlta, clientes.eliminado)
    }

    fun update(clientes: clientes): Int {
        val sql = "UPDATE clientes SET RFC=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  clientes.RFC, clientes.nombre, clientes.direccion, clientes.territorio, clientes.estado, clientes.codPostal, clientes.telefono, clientes.correo, clientes.fechaAlta ,clientes.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE clientes SET eliminado=? WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql, rfc)
    }
}