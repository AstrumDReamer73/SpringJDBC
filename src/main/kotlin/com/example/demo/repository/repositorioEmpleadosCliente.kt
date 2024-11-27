package com.example.demo.repository

import com.example.demo.model.empleadosClientes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class repositorioEmpleadosCliente @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<empleadosClientes> {
        val sql = "SELECT * FROM empleadosClientes WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosClientes::class.java))
    }

    fun findAllActive(): List<empleadosClientes> {
        val sql = "SELECT * FROM empleadosClientes where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosClientes::class.java))
    }

    fun save(empleadosClientes: empleadosClientes): Int {
        val sql = "INSERT INTO empleadosClientes VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, empleadosClientes.RFC,empleadosClientes.RFCEmpleador, empleadosClientes.nombre, empleadosClientes.direccion, empleadosClientes.territorio, empleadosClientes.estado, empleadosClientes.codPostal, empleadosClientes.telefono, empleadosClientes.correo, empleadosClientes.fechaAlta, empleadosClientes.eliminado)
    }

    fun update(empleadosClientes: empleadosClientes): Int {
        val sql = "UPDATE empleadosClientes SET RFC=?, RFCEmpleador=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  empleadosClientes.RFC,empleadosClientes.RFCEmpleador, empleadosClientes.nombre, empleadosClientes.direccion, empleadosClientes.territorio, empleadosClientes.estado, empleadosClientes.codPostal, empleadosClientes.telefono, empleadosClientes.correo, empleadosClientes.fechaAlta ,empleadosClientes.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE empleadosClientes SET eliminado=? WHERE RFC=?"
        return jdbcTemplate.update(sql, rfc)
    }
}