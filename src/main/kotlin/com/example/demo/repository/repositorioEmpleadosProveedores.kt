package com.example.demo.repository

import com.example.demo.model.empleadosProveedores
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class repositorioEmpleadosProveedores @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<empleadosProveedores> {
        val sql = "SELECT * FROM empleadosProveedores WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosProveedores::class.java))
    }

    fun findAllActive(): List<empleadosProveedores> {
        val sql = "SELECT * FROM empleadosProveedores where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(empleadosProveedores::class.java))
    }

    fun save(empleadosProveedores: empleadosProveedores): Int {
        val sql = "INSERT INTO empleadosProveedores VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, empleadosProveedores.RFC,empleadosProveedores.RFCEmpleador, empleadosProveedores.nombre, empleadosProveedores.direccion, empleadosProveedores.territorio, empleadosProveedores.estado, empleadosProveedores.codPostal, empleadosProveedores.telefono, empleadosProveedores.correo, empleadosProveedores.fechaAlta, empleadosProveedores.eliminado)
    }

    fun update(empleadosProveedores: empleadosProveedores): Int {
        val sql = "UPDATE empleadosProveedores SET RFC=?, RFCEmpleador=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, correo=?, fechaAlta=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  empleadosProveedores.RFC,empleadosProveedores.RFCEmpleador, empleadosProveedores.nombre, empleadosProveedores.direccion, empleadosProveedores.territorio, empleadosProveedores.estado, empleadosProveedores.codPostal, empleadosProveedores.telefono, empleadosProveedores.correo, empleadosProveedores.fechaAlta ,empleadosProveedores.eliminado)
    }

    fun deleteByID(rfc:String): Int {
        val sql = "UPDATE empleadosProveedores SET eliminado=? WHERE RFC=?"
        return jdbcTemplate.update(sql, rfc)
    }
}