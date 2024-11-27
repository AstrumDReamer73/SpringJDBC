package com.example.demo.service

import com.example.demo.model.detallesdeCompra
import com.example.demo.model.detallesdeVentas
import com.example.demo.repository.repositorioDetallesdeVentas
import org.springframework.beans.factory.annotation.Autowired

class detallesdeVentasService @Autowired constructor(private val repositorioDetallesdeVentas: repositorioDetallesdeVentas){
    fun findAll(): List<detallesdeVentas> {
        return try { repositorioDetallesdeVentas.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllbyFactura(factura:String): List<detallesdeVentas> {
        return try { repositorioDetallesdeVentas.findAllByFactura(factura) }
        catch (e: Exception) { throw e }
    }

    fun insert(detallesdeVentas: detallesdeVentas):Int{
        return try { repositorioDetallesdeVentas.save(detallesdeVentas) }
        catch (e:Exception){ throw e }
    }

    fun update(detallesdeVentas: detallesdeVentas): Int {
        return try { repositorioDetallesdeVentas.update(detallesdeVentas) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioDetallesdeVentas.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}