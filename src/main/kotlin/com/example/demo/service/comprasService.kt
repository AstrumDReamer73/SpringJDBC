package com.example.demo.service

import com.example.demo.model.clientes
import com.example.demo.model.compras
import com.example.demo.repository.repositorioClientes
import com.example.demo.repository.repositorioCompras
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper

class comprasService @Autowired constructor(private val repositorioCompras: repositorioCompras){
    fun findAll(): List<compras> {
        return try { repositorioCompras.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<compras> {
        return try { repositorioCompras.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun insert(compras: compras):Int{
        return try { repositorioCompras.save(compras) }
        catch (e:Exception){ throw e }
    }

    fun update(compras: compras): Int {
        return try { repositorioCompras.update(compras) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(factura:String): Int {
        return try { repositorioCompras.deleteByFactura(factura)
        } catch (e: Exception) { throw e }
    }
}