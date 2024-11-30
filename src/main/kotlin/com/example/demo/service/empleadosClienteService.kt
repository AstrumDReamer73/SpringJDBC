package com.example.demo.service

import com.example.demo.model.empleadosCliente
import com.example.demo.repository.repositorioEmpleadosCliente
import org.springframework.beans.factory.annotation.Autowired

class empleadosClienteService @Autowired constructor(private val repositorioEmpleadosCliente: repositorioEmpleadosCliente){
    fun findAll(): List<empleadosCliente> {
        return try { repositorioEmpleadosCliente.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<empleadosCliente> {
        return try { repositorioEmpleadosCliente.findAllActive() }
        catch (e: Exception) { throw e }
    }


    fun insert(empleadosCliente: empleadosCliente):Int{
        return try { repositorioEmpleadosCliente.save(empleadosCliente) }
        catch (e:Exception){ throw e }
    }

    fun update(empleadosCliente: empleadosCliente): Int {
        return try { repositorioEmpleadosCliente.update(empleadosCliente) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioEmpleadosCliente.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}