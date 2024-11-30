package com.example.demo.repository

import com.example.demo.model.empleadosCliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioEmpleadosCliente @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<empleadosCliente> {
        val sql = "SELECT * FROM empleadosClientes WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosCliente::class.java))
    }

    fun findAllActive(): List<empleadosCliente> {
        val sql = "SELECT * FROM empleadosClientes where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosCliente::class.java))
    }

    fun save(empleadosCliente: empleadosCliente): Int {
        val sql = "INSERT INTO empleadosClientes VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, empleadosCliente.RFC,empleadosCliente.RFCEmpleador, empleadosCliente.nombre, empleadosCliente.direccion, empleadosCliente.territorio, empleadosCliente.estado, empleadosCliente.codPostal, empleadosCliente.telefono, empleadosCliente.correo, empleadosCliente.fechaAlta, empleadosCliente.eliminado)
    }

    fun update(empleadosCliente: empleadosCliente): Int {
        val sql = "UPDATE empleadosClientes SET RFC=?, RFCEmpleador=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  empleadosCliente.RFC,empleadosCliente.RFCEmpleador, empleadosCliente.nombre, empleadosCliente.direccion, empleadosCliente.territorio, empleadosCliente.estado, empleadosCliente.codPostal, empleadosCliente.telefono, empleadosCliente.correo, empleadosCliente.fechaAlta ,empleadosCliente.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE empleadosClientes SET eliminado=? WHERE RFC=?"
        return jdbcTemplate.update(sql, rfc)
    }
}