package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.service.categoriaService
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/categorias") class categoriasController(private val categoriaService: categoriaService) {
    @GetMapping fun getAll(): List<categoria> { return categoriaService.findAll() }

    @PostMapping fun create(@RequestBody categoria: categoria): categoria { return categoriaService.save(categoria) }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody categoria: categoria): categoria { return categoriaService.update(categoria.copy(IDCategoria = id)) }

    @DeleteMapping("/{id}") fun delete(@PathVariable id: Int) { categoriaService.deleteById(id) }
}
