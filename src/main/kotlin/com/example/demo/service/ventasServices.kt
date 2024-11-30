package com.example.demo.service

import com.example.demo.model.venta
import com.example.demo.repository.repositorioVentas
import org.springframework.beans.factory.annotation.Autowired

class ventasServices @Autowired constructor(private val repositorioVentas: repositorioVentas){
    fun findAll(): List<venta> {
        return try { repositorioVentas.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<venta> {
        return try { repositorioVentas.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun insert(venta: venta):Int{
        return try { repositorioVentas.save(venta) }
        catch (e:Exception){ throw e }
    }

    fun update(venta: venta): Int {
        return try { repositorioVentas.update(venta) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(factura:String): Int {
        return try { repositorioVentas.deleteByFactura(factura)
        } catch (e: Exception) { throw e }
    }
}