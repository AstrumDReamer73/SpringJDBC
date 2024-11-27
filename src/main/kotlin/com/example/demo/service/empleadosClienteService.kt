package com.example.demo.service

import com.example.demo.model.empleadosClientes
import com.example.demo.repository.repositorioEmpleadosCliente
import org.springframework.beans.factory.annotation.Autowired

class empleadosClienteService @Autowired constructor(private val repositorioEmpleadosCliente: repositorioEmpleadosCliente){
    fun findAll(): List<empleadosClientes> {
        return try { repositorioEmpleadosCliente.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<empleadosClientes> {
        return try { repositorioEmpleadosCliente.findAllActive() }
        catch (e: Exception) { throw e }
    }


    fun insert(empleadosClientes: empleadosClientes):Int{
        return try { repositorioEmpleadosCliente.save(empleadosClientes) }
        catch (e:Exception){ throw e }
    }

    fun update(empleadosClientes: empleadosClientes): Int {
        return try { repositorioEmpleadosCliente.update(empleadosClientes) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioEmpleadosCliente.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}