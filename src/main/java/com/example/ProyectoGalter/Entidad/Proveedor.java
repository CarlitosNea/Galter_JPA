package com.example.ProyectoGalter.Entidad;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proveedor")
public class Proveedor {


    // Creacion de columnas
    @Id
    @Column(unique = true,length = 50)
    private String nombre_proveedor;

    @ManyToOne
    @JoinColumn(referencedColumnName = "nombre_proveedor")
    private Proveedor proveedor;


    // Creacion de constructores


    public Proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public Proveedor() {
    }


    // Metodos GET & SET

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    // To String


    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre_proveedor='" + nombre_proveedor + '\'' +
                '}';
    }
}
