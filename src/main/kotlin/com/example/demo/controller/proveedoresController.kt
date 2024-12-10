package com.example.demo.controller

import com.example.demo.model.compra
import com.example.demo.model.empleadosProveedor
import com.example.demo.model.proveedor
import com.example.demo.model.venta
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

    @GetMapping("/activos") fun findAllActive(model: Model):String {
        model.addAttribute("proveedores", proveedoresService.findAllActiveSuppliers())
        return "redirect:/listaProveedores"
    }

    @PostMapping("/añadirProveedor") fun save(@RequestBody proveedor: proveedor):String {
        proveedoresService.save(proveedor)
        return "redirect:/listaProveedores"
    }

    @PutMapping("/{rfc}/update") fun update(@PathVariable rfc: String,@RequestBody proveedor: proveedor):String {
        proveedor.copy(RFC = rfc).let { proveedoresService.update(it) }
        return "redirect:/listaProveedores"
    }

    @DeleteMapping("/{rfc}/delete") fun delete(@PathVariable rfc:String):String {
        proveedoresService.deleteById(rfc)
        return "redirect:/listaProveedores"
    }

    @GetMapping("/{rfc}/empleados")
    fun findEmpleadosbyEmployee(@PathVariable rfc: String, model: Model): String {
        model.addAttribute("empleados", proveedoresService.findEmpleadosbyEmployee(rfc))
        return "listaEmpleadosProveedores"
    }

    @GetMapping("/{rfc}/compras")
    fun findComprasporProveedor(@PathVariable rfc: String, model: Model): String {
        model.addAttribute("compras", proveedoresService.findComprasporProveedor(rfc))
        return "listaCompras"
    }
}