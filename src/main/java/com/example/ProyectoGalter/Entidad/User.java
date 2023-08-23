package com.example.ProyectoGalter.Entidad;

import  jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    // Creacion de columnas
    @Id
    private String email;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Column(name = "img")
    private String img;

    @Column(name = "auth_id", unique = true)
    private String auth_id;

    @Column(name = "rol")
    private String rol;


    // Constructores

    public User() {
    }

    public User(String email, String nickname, String img, String auth_id, String rol) {
        this.email = email;
        this.nickname = nickname;
        this.img = img;
        this.auth_id = auth_id;
        this.rol = rol;
    }


    // GET & SET


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
}
