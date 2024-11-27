package com.example.demo.service

import com.example.demo.model.articulos
import com.example.demo.model.categoria
import com.example.demo.repository.repositorioCategoria
import org.springframework.beans.factory.annotation.Autowired

class categoriaService @Autowired constructor(private val repositorioCategoria: repositorioCategoria){
    fun findAll(): List<categoria> {
        return try { repositorioCategoria.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllArticulos(id: Int): List<articulos> {
        return try { repositorioCategoria.findAllArticulos(id) }
        catch (e: Exception) { throw e }
    }

    fun insert(categoria: categoria):Int{
        return try { repositorioCategoria.save(categoria) }
        catch (e:Exception){ throw e }
    }

    fun update(categoria: categoria): Int {
        return try { repositorioCategoria.update(categoria) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioCategoria.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}