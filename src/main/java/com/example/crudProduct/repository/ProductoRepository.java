package com.example.crudProduct.repository;

import com.example.crudProduct.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("Select p FROM Producto p WHERE p.id LIKE %?1%" +
            " OR p.nombre LIKE %?1%" +
            " OR p.procedencia LIKE %?1%" +
            " OR p.fabricante LIKE %?1%")

    public List<Producto> search(String criterioBusqueda);
}

