package com.example.demo.service

import com.example.demo.model.ventas
import com.example.demo.repository.repositorioVentas
import org.springframework.beans.factory.annotation.Autowired

class ventasServices @Autowired constructor(private val repositorioVentas: repositorioVentas){
    fun findAll(): List<ventas> {
        return try { repositorioVentas.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<ventas> {
        return try { repositorioVentas.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun insert(ventas: ventas):Int{
        return try { repositorioVentas.save(ventas) }
        catch (e:Exception){ throw e }
    }

    fun update(ventas: ventas): Int {
        return try { repositorioVentas.update(ventas) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(factura:String): Int {
        return try { repositorioVentas.deleteByFactura(factura)
        } catch (e: Exception) { throw e }
    }
}