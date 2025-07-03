package com.example.demo.controller

import com.example.demo.model.proveedor
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaProveedores") class proveedoresController{
    @Autowired private lateinit var proveedoresService: proveedoresService

    @GetMapping fun findAll(model: Model):String{
        model.addAttribute("proveedores",proveedoresService.findAllSuppliers())
        return "listaProveedores"
    }

    @GetMapping("/guardar") fun findAllActive(model: Model):String {
        model.addAttribute("proveedores", proveedoresService.findAllActiveSuppliers())
        return "redirect:/listaProveedores"
    }

    @GetMapping("/empleados/{rfc}")
    fun findEmpleadosbyEmployee(@PathVariable rfc: String, model: Model): String {
        model.addAttribute("empleadosProveedores", proveedoresService.findEmpleadosbyEmployeer(rfc))
        return "listaEmpleadosProveedores"
    }

    @GetMapping("/compras/{rfc}")
    fun findComprasporProveedor(@PathVariable rfc: String, model: Model): String {
        model.addAttribute("compras", proveedoresService.findByProveedor(rfc))
        return "listaCompras"
    }

    @GetMapping("/añadirProveedor") fun showAddForm(model: Model):String{
        model.addAttribute("proveedor",proveedor())
        return "añadirProveedor"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute proveedor: proveedor):String {
        proveedoresService.save(proveedor)
        return "redirect:/listaProveedores"
    }

    @GetMapping("/editar/{RFC}")fun showEditForm(@PathVariable RFC:String,model: Model):String{
        val cliente =proveedoresService.findSupplierbyRFC(RFC)
        model.addAttribute("cliente",cliente)
        return "editarCliente"
    }

    @PostMapping("/actualizar/{RFC}")fun update(proveedor: proveedor):String{
        proveedoresService.update(proveedor)
        return "redirect:/listaCategorias"
    }

    @GetMapping("eliminar/{RFC}")fun delete(@PathVariable RFC: String):String{
        proveedoresService.deletebyRFC(RFC)
        return "redirect:/listaCategorias"
    }
}