package com.example.demo.service

import com.example.demo.model.clientes
import com.example.demo.model.empleadosClientes
import com.example.demo.model.ventas
import com.example.demo.repository.repositorioClientes
import org.springframework.beans.factory.annotation.Autowired

class clientesService @Autowired constructor(private val repositorioClientes: repositorioClientes){
    fun findAll(): List<clientes> {
        return try { repositorioClientes.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<clientes> {
        return try { repositorioClientes.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun findAllEmpleados(RFC: String): List<empleadosClientes> {
        return try { repositorioClientes.findAllEmpleados(RFC) }
        catch (e: Exception) { throw e }
    }

    fun findAllSells(RFC: String): List<ventas> {
        return try { repositorioClientes.findAllSells(RFC) }
        catch (e: Exception) { throw e }
    }

    fun insert(clientes: clientes):Int{
        return try { repositorioClientes.save(clientes) }
        catch (e:Exception){ throw e }
    }

    fun update(clientes: clientes): Int {
        return try { repositorioClientes.update(clientes) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioClientes.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}