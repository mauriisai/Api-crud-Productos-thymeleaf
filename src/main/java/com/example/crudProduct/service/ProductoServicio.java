package com.example.crudProduct.service;

import com.example.crudProduct.model.Producto;
import com.example.crudProduct.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    ProductoRepository productoRepository;

    @Autowired
    public ProductoServicio(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProducts(String criterioBusqueda) {
        if(criterioBusqueda != null){
            return productoRepository.search(criterioBusqueda);
        }
        return productoRepository.findAll();
    }

    public void addProduct(Producto producto) {
        productoRepository.save(producto);
    }

    public void removeProduct(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto get(Long id){
        return productoRepository.findById(id).get();
    }

    public void updateProduct(){

    }

}

