package com.example.crudProduct.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false, length =150)
    private String nombre;

    @Column(nullable = false,length =30)
    private String fabricante;

    @Column(nullable = false,length =40)
    private String procedencia;

    @Column(nullable = false)
    private float precio;

}