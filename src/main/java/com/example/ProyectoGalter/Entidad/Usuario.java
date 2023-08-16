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

    @Column(name = "img")
    private String img;

    @Column(name = "auth_id", unique = true)
    private String auth_id;

    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "usuario_ped", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedido;


    // Creacion de constructores

    public Usuario() {
    }

    public Usuario(String codi_usuario, String nombre_usuario, String correo_usuario, String pass_usuario, int tipo_usuario, String img, String auth_id, String rol, Set<Pedido> pedido) {
        this.codi_usuario = codi_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correo_usuario = correo_usuario;
        this.pass_usuario = pass_usuario;
        this.tipo_usuario = tipo_usuario;
        this.img = img;
        this.auth_id = auth_id;
        this.rol = rol;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // To String

    @Override
    public String toString() {
        return "Usuario{" +
                "codi_usuario='" + codi_usuario + '\'' +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", correo_usuario='" + correo_usuario + '\'' +
                ", pass_usuario='" + pass_usuario + '\'' +
                ", tipo_usuario=" + tipo_usuario +
                ", img='" + img + '\'' +
                ", auth_id='" + auth_id + '\'' +
                ", rol ='" + rol + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}