package com.example.proyecto_galter.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {


    // Creacion de columnas
    @Id
    @Column(unique = true,length = 50)
    private String nombre_usuario;


    // Creacion de constructores


    public Usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public Usuario() {
    }


    // Metodos GET & SET

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }


    // To String


    @Override
    public String toString() {
        return "usuarios{" +
                "nombre_usuario='" + nombre_usuario + '\'' +
                '}';
    }
}