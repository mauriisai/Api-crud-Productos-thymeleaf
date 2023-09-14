package com.example.crudProduct.controller;

import com.example.crudProduct.model.Producto;
import com.example.crudProduct.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductoController {

    ProductoServicio productoServicio;

    @Autowired
    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

//    @RequestMapping("/get")
//    public String showMainView(Model modelo){
//        List<Producto> listaProductos = productoServicio.getProducts();
//        modelo.addAttribute("listaProductos", listaProductos);
//        return "viewProductos";
//    }


    @RequestMapping("/get")
    public String showMainView(Model modelo, @Param("criterioBusqeda") String criterioBusqueda){
        List<Producto> listaProductos = productoServicio.getProducts(criterioBusqueda);

        modelo.addAttribute("listaProductos", listaProductos);
        modelo.addAttribute("criterioBusqueda", criterioBusqueda);
        return "viewProductos";
    }

    @RequestMapping("/newProduct")
    public String formNewProduct(Model modelo){
        Producto product = new Producto();
        modelo.addAttribute("producto", product);
        return "newProduct";
    }

    @PostMapping("/registrar")
    public String guardarEstudiante(@ModelAttribute("producto") Producto producto) {
        productoServicio.addProduct(producto);
        return "redirect:/products/get";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView formUpdateProduct(@PathVariable long id){
        ModelAndView modelo = new ModelAndView("updateProduct");
        Producto producto = productoServicio.get(id);
        modelo.addObject("producto", producto);
        return modelo;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productoServicio.removeProduct(id);
        return "redirect:/products/get";
    }

}

