package com.example.demo.service

import com.example.demo.model.empleadosClientes
import com.example.demo.model.empleadosProveedores
import com.example.demo.repository.repositorioEmpleadosCliente
import org.springframework.beans.factory.annotation.Autowired

class empleadosProvedoresService @Autowired constructor(private val repositorioEmpleadosproveedoresService: empleadosProvedoresService) {
    fun findAll(): List<empleadosClientes> {
        return try { repositorioEmpleadosCliente.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<empleadosClientes> {
        return try { repositorioEmpleadosCliente.findAllActive() }
        catch (e: Exception) { throw e }
    }


    fun insert(empleadosProveedores: empleadosProveedores):Int{
        return try { repositorioEmpleadosCliente.save(empleadosClientes) }
        catch (e:Exception){ throw e }
    }

    fun update(empleadosProveedores: empleadosProveedores): Int {
        return try { repositorioEmpleadosCliente.update(empleadosClientes) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioEmpleadosCliente.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}