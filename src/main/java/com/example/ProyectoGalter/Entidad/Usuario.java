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
    private String nombres_usuario;

    @Column(unique = true,length = 50)
    private String apellidos_usuario;

    @Column(unique = true,length = 50)
    private String correoUsuario;

    @Column(nullable = false)
    private int tipo_usuario;

    @OneToMany(mappedBy = "usuario_ped", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedido;


    // Creacion de constructores

    public Usuario() {
    }

    public Usuario(String codi_usuario, String nombres_usuario, String apellidos_usuario, String correoUsuario, int tipo_usuario, Set<Pedido> pedido) {
        this.codi_usuario = codi_usuario;
        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.correoUsuario = correoUsuario;
        this.tipo_usuario = tipo_usuario;
        this.pedido = pedido;
    }

    // GET & SET


    public String getCodi_usuario() {
        return codi_usuario;
    }

    public void setCodi_usuario(String codi_usuario) {
        this.codi_usuario = codi_usuario;
    }

    public String getNombres_usuario() {
        return nombres_usuario;
    }

    public void setNombres_usuario(String nombres_usuario) {
        this.nombres_usuario = nombres_usuario;
    }

    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) {
        this.apellidos_usuario = apellidos_usuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
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


    // To string

    @Override
    public String toString() {
        return "Usuario{" +
                "codi_usuario='" + codi_usuario + '\'' +
                ", nombres_usuario='" + nombres_usuario + '\'' +
                ", apellidos_usuario='" + apellidos_usuario + '\'' +
                ", correo_usuario='" + correoUsuario + '\'' +
                ", tipo_usuario=" + tipo_usuario +
                ", pedido=" + pedido +
                '}';
    }
}