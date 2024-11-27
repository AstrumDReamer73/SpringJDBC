package com.example.demo.repository

import com.example.demo.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class repositorioProveedores @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<proveedores> {
        val sql = "SELECT * FROM proveedores"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(proveedores::class.java))
    }

    fun findAllActive(): List<proveedores> {
        val sql = "SELECT * FROM proveedores where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(proveedores::class.java))
    }

    fun findAllEmpleados(RFC: String):List<empleadosClientes>{
        val sql = "SELECT * FROM empleados WHERE rfcEmpleador=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosClientes::class.java))
    }

    fun findAllPurchases(RFC: String):List<compras>{
        val sql = "SELECT * FROM ventas WHERE proveedor=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(compras::class.java))
    }

    fun save(proveedores: proveedores): Int {
        val sql = "INSERT INTO proveedores VALUES (?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, proveedores.RFC, proveedores.nombre, proveedores.direccion, proveedores.territorio, proveedores.estado, proveedores.codPostal, proveedores.telefono, proveedores.correo, proveedores.fechaAlta, proveedores.eliminado)
    }

    fun update(proveedores: proveedores): Int {
        val sql = "UPDATE proveedores SET RFC=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  proveedores.RFC, proveedores.nombre, proveedores.direccion, proveedores.territorio, proveedores.estado, proveedores.codPostal, proveedores.telefono, proveedores.correo, proveedores.fechaAlta ,proveedores.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE proveedores SET eliminado=? WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql, rfc)
    }
}