package com.example.demo.controller
import com.example.demo.model.articulo
import com.example.demo.service.articulosService
import com.example.demo.service.categoriaService
import com.example.demo.service.ubicacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller @RequestMapping("/listaArticulos") class articulosController {
    @Autowired private lateinit var articulosService: articulosService
    @Autowired private lateinit var categoriaService: categoriaService
    @Autowired private lateinit var ubicacionService: ubicacionService

    @GetMapping fun findAll(model: Model): String {
        model.addAttribute("articulos", articulosService.findAll())
        return "listaArticulos"
    }

    @GetMapping("/activos") fun findAllActive(model: Model): String {
        model.addAttribute("articulos", articulosService.findAllActive())
        return "listaArticulos"
    }

    @GetMapping("/{UPC}/existencias") fun findAllExistences(@PathVariable UPC: Int, model: Model): String {
        model.addAttribute("articulos", articulosService.findAllExistences(UPC))
        return "listaArticulos"
    }

    @GetMapping("/{idcategoria}/articulos") fun findByCategoria(@PathVariable idcategoria:Int,model: Model):String{
        model.addAttribute("articulos",articulosService.findByCategoria(idcategoria))
        return "listaArticulos"
    }

    @GetMapping("/añadirArticulo")fun showAddForm(model: Model):String{
        model.addAttribute("articulo",articulo())
        model.addAttribute("listaCategorias", categoriaService.findAllActive())
        model.addAttribute("listaUbicacion", ubicacionService.findAllActive())
        return "añadirArticulo"
    }

    @PostMapping("/guardar")
    fun save(
        @ModelAttribute articulo: articulo,
        @RequestParam ubicacion: Int,
        @RequestParam categoria: Int
    ): String {
        val ubicacion = ubicacionService.findById(ubicacion)
        val categoria = categoriaService.findbyID(categoria)
        articulo.ubicacion = ubicacion
        articulo.categoria = categoria
        articulosService.save(articulo)
        return "redirect:/listaArticulos"
    }


    @GetMapping("/editar/{upc}")fun showEditForm(@PathVariable upc:Int,model: Model):String{
        val articulo=articulosService.findbyUPC(upc)
        if(articulo!=null) {
            model.addAttribute("articulo", articulo())
            model.addAttribute("listaCategorias", categoriaService.findAllActive())
            model.addAttribute("listaUbicacion", ubicacionService.findAllActive())
        }
        return "añadirArticulo"
    }

    @PostMapping("/actualizar/{upc}")fun update(@ModelAttribute articulo: articulo,
                                             @RequestParam ubicacion: Int,
                                             @RequestParam categoria: Int):String{
        val ubicacion = ubicacionService.findById(ubicacion)
        val categoria = categoriaService.findbyID(categoria)
        articulo.ubicacion = ubicacion
        articulo.categoria = categoria
        articulosService.update(articulo)
        return "redirect:/listaArticulos"
    }


    @GetMapping("/eliminar/{upc}") fun delete(@PathVariable upc: Int):String {
        articulosService.deleteByUPC(upc)
        return "redirect:/listaArticulos"
    }
}
