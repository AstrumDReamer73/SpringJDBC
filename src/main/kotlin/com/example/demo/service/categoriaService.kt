package com.example.demo.service

import com.example.demo.model.articulos
import com.example.demo.model.categoria
import com.example.demo.repository.repositorioCategorias
import org.springframework.beans.factory.annotation.Autowired

class categoriaService @Autowired constructor(private val repositorioCategorias: repositorioCategorias){
    fun findAll(): List<categoria> {
        return try { repositorioCategorias.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllArticulos(id: Int): List<articulos> {
        return try { repositorioCategorias.findAllArticulos(id) }
        catch (e: Exception) { throw e }
    }

    fun insert(categoria: categoria):Int{
        return try { repositorioCategorias.save(categoria) }
        catch (e:Exception){ throw e }
    }

    fun update(categoria: categoria): Int {
        return try { repositorioCategorias.update(categoria) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioCategorias.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}