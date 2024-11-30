package com.example.demo.service

import com.example.demo.model.compra
import com.example.demo.model.empleadosCliente
import com.example.demo.model.proveedor
import com.example.demo.repository.repositorioProveedores
import org.springframework.beans.factory.annotation.Autowired

class proveedoresService @Autowired constructor(private val repositorioProveedores: repositorioProveedores){
    fun findAll(): List<proveedor> {
        return try { repositorioProveedores.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllEmpleados(RFC: String): List<empleadosCliente> {
        return try { repositorioProveedores.findAllEmpleados(RFC) }
        catch (e: Exception) { throw e }
    }

    fun findAllPurchases(RFC: String): List<compra> {
        return try { repositorioProveedores.findAllPurchases(RFC) }
        catch (e: Exception) { throw e }
    }

    fun insert(proveedor: proveedor):Int{
        return try { repositorioProveedores.save(proveedor) }
        catch (e:Exception){ throw e }
    }

    fun update(proveedor: proveedor): Int {
        return try { repositorioProveedores.update(proveedor) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(RFC:String): Int {
        return try { repositorioProveedores.deleteByID(RFC)
        } catch (e: Exception) { throw e }
    }
}