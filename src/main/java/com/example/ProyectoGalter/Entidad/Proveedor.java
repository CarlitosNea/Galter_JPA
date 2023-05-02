package com.example.ProyectoGalter.Entidad;


import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {


    // Creacion de columnas
    @Id
    @Column(unique = true,length = 50)
    private String nombre_proveedor;


    // Creacion de constructores
    public Proveedor(String nombre_proveedor) {
        this.setNombre_proveedor(nombre_proveedor);
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
