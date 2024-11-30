package com.example.demo.service

import com.example.demo.model.cliente
import com.example.demo.model.empleadosCliente
import com.example.demo.model.venta
import com.example.demo.repository.repositorioClientes
import org.springframework.beans.factory.annotation.Autowired

class clientesService @Autowired constructor(private val repositorioClientes: repositorioClientes){
    fun findAll(): List<cliente> {
        return try { repositorioClientes.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<cliente> {
        return try { repositorioClientes.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun findAllEmpleados(RFC: String): List<empleadosCliente> {
        return try { repositorioClientes.findAllEmpleados(RFC) }
        catch (e: Exception) { throw e }
    }

    fun findAllSells(RFC: String): List<venta> {
        return try { repositorioClientes.findAllSells(RFC) }
        catch (e: Exception) { throw e }
    }

    fun insert(cliente: cliente):Int{
        return try { repositorioClientes.save(cliente) }
        catch (e:Exception){ throw e }
    }

    fun update(cliente: cliente): Int {
        return try { repositorioClientes.update(cliente) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioClientes.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}