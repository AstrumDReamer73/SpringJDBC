package com.example.demo.service

import com.example.demo.model.empleadosProveedor
import com.example.demo.repository.repositorioEmpleadosProveedores
import org.springframework.beans.factory.annotation.Autowired

class empleadosProvedoresService @Autowired constructor(private val repositorioEmpleadosProveedores: repositorioEmpleadosProveedores) {
    fun findAll(): List<empleadosProveedor> {
        return try { repositorioEmpleadosProveedores.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<empleadosProveedor> {
        return try { repositorioEmpleadosProveedores.findAllActive() }
        catch (e: Exception) { throw e }
    }


    fun insert(empleadosProveedores: empleadosProveedor):Int{
        return try { repositorioEmpleadosProveedores.save(empleadosProveedores) }
        catch (e:Exception){ throw e }
    }

    fun update(empleadosProveedores: empleadosProveedor): Int {
        return try { repositorioEmpleadosProveedores.update(empleadosProveedores) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioEmpleadosProveedores.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}