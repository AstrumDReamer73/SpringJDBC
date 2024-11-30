package com.example.demo.service

import com.example.demo.model.compra
import com.example.demo.repository.repositorioCompras
import org.springframework.beans.factory.annotation.Autowired

class comprasService @Autowired constructor(private val repositorioCompras: repositorioCompras){
    fun findAll(): List<compra> {
        return try { repositorioCompras.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<compra> {
        return try { repositorioCompras.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun insert(compra: compra):Int{
        return try { repositorioCompras.save(compra) }
        catch (e:Exception){ throw e }
    }

    fun update(compra: compra): Int {
        return try { repositorioCompras.update(compra) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(factura:String): Int {
        return try { repositorioCompras.deleteByFactura(factura)
        } catch (e: Exception) { throw e }
    }
}