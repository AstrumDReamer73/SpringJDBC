package com.example.demo.service

import com.example.demo.model.detallesdeVenta
import com.example.demo.repository.repositorioDetallesdeVentas
import org.springframework.beans.factory.annotation.Autowired

class detallesdeVentasService @Autowired constructor(private val repositorioDetallesdeVentas: repositorioDetallesdeVentas){
    fun findAll(): List<detallesdeVenta> {
        return try { repositorioDetallesdeVentas.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllbyFactura(factura:String): List<detallesdeVenta> {
        return try { repositorioDetallesdeVentas.findAllByFactura(factura) }
        catch (e: Exception) { throw e }
    }

    fun insert(detallesdeVenta: detallesdeVenta):Int{
        return try { repositorioDetallesdeVentas.save(detallesdeVenta) }
        catch (e:Exception){ throw e }
    }

    fun update(detallesdeVenta: detallesdeVenta): Int {
        return try { repositorioDetallesdeVentas.update(detallesdeVenta) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioDetallesdeVentas.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}