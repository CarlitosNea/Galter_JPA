package com.example.ProyectoGalter.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {


    // Creacion de columnas
    @Id
    @Column(nullable = false)
    private String codi_usuario;

    @Column(unique = true,length = 50)
    private String nombre_usuario;

    @Column(unique = true,length = 50)
    private String correo_usuario;

    @Column(unique = true,length = 100)
    private String pass_usuario;

    @Column(nullable = false)
    private int tipo_usuario;

    @OneToMany(mappedBy = "usuario_ped", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedido;


    // Creacion de constructores

    public Usuario() {
    }

    public Usuario(String codi_usuario, String nombre_usuario, String correo_usuario, String pass_usuario, int tipo_usuario, Set<Pedido> pedido) {
        this.codi_usuario = codi_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correo_usuario = correo_usuario;
        this.pass_usuario = pass_usuario;
        this.tipo_usuario = tipo_usuario;
        this.pedido = pedido;
    }


    // Metodos GET & SET

    public String getCodi_usuario() {
        return codi_usuario;
    }

    public void setCodi_usuario(String codi_usuario) {
        this.codi_usuario = codi_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public Set<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(Set<Pedido> pedido) {
        this.pedido = pedido;
    }

    // To String


    @Override
    public String toString() {
        return "Usuario{" +
                "codi_usuario=" + codi_usuario +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", correo_usuario='" + correo_usuario + '\'' +
                ", pass_usuario='" + pass_usuario + '\'' +
                ", tipo_usuario=" + tipo_usuario +
                ", pedidos=" + pedido +
                '}';
    }
}