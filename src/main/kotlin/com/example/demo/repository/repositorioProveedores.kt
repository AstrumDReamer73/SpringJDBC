package com.example.demo.repository

import com.example.demo.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioProveedores @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<proveedor> {
        val sql = "SELECT * FROM proveedores"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(proveedor::class.java))
    }

    fun findAllActive(): List<proveedor> {
        val sql = "SELECT * FROM proveedores where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(proveedor::class.java))
    }

    fun findAllEmpleados(RFC: String):List<empleadosCliente>{
        val sql = "SELECT * FROM empleados WHERE rfcEmpleador=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosCliente::class.java))
    }

    fun findAllPurchases(RFC: String):List<compra>{
        val sql = "SELECT * FROM ventas WHERE proveedor=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(compra::class.java))
    }

    fun save(proveedor: proveedor): Int {
        val sql = "INSERT INTO proveedores VALUES (?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, proveedor.RFC, proveedor.nombre, proveedor.direccion, proveedor.territorio, proveedor.estado, proveedor.codPostal, proveedor.telefono, proveedor.correo, proveedor.fechaAlta, proveedor.eliminado)
    }

    fun update(proveedor: proveedor): Int {
        val sql = "UPDATE proveedores SET RFC=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  proveedor.RFC, proveedor.nombre, proveedor.direccion, proveedor.territorio, proveedor.estado, proveedor.codPostal, proveedor.telefono, proveedor.correo, proveedor.fechaAlta ,proveedor.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE proveedores SET eliminado=? WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql, rfc)
    }
}