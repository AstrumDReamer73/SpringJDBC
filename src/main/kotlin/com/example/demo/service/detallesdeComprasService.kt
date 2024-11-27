package com.example.demo.service

import com.example.demo.model.detallesdeCompra
import com.example.demo.repository.repositorioDetallesdeCompras
import org.springframework.beans.factory.annotation.Autowired

class detallesdeComprasService @Autowired constructor(private val repositorioDetallesdeCompras: repositorioDetallesdeCompras){
    fun findAll(): List<detallesdeCompra> {
        return try { repositorioDetallesdeCompras.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllbySelling(factura:String): List<detallesdeCompra> {
        return try { repositorioDetallesdeCompras.findAllbyFactura(factura) }
        catch (e: Exception) { throw e }
    }

    fun insert(detallesdeCompra: detallesdeCompra):Int{
        return try { repositorioDetallesdeCompras.save(detallesdeCompra) }
        catch (e:Exception){ throw e }
    }

    fun update(detallesdeCompra: detallesdeCompra): Int {
        return try { repositorioDetallesdeCompras.update(detallesdeCompra) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioDetallesdeCompras.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}