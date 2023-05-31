package com.example.ProyectoGalter.Entidad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {


    @Id
    @Column(unique = true,length = 50)
    private String nombre_cliente;


    public Cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Cliente() {
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public String
    toString() {
        return "clientes{" +
                "nombre_cliente='" + nombre_cliente + '\'' +
                '}';
    }
}
