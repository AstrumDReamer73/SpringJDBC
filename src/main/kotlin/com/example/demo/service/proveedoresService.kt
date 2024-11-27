package com.example.demo.service

import com.example.demo.model.compras
import com.example.demo.model.empleadosClientes
import com.example.demo.model.proveedores
import com.example.demo.repository.repositorioProveedores
import org.springframework.beans.factory.annotation.Autowired

class proveedoresService @Autowired constructor(private val repositorioProveedores: repositorioProveedores){
    fun findAll(): List<proveedores> {
        return try { repositorioProveedores.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllEmpleados(RFC: String): List<empleadosClientes> {
        return try { repositorioProveedores.findAllEmpleados(RFC) }
        catch (e: Exception) { throw e }
    }

    fun findAllPurchases(RFC: String): List<compras> {
        return try { repositorioProveedores.findAllPurchases(RFC) }
        catch (e: Exception) { throw e }
    }

    fun insert(proveedores: proveedores):Int{
        return try { repositorioProveedores.save(proveedores) }
        catch (e:Exception){ throw e }
    }

    fun update(proveedores: proveedores): Int {
        return try { repositorioProveedores.update(proveedores) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioProveedores.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}