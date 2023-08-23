package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.User;
import com.example.ProyectoGalter.Entidad.Usuario;
import com.example.ProyectoGalter.Repositorio.Repo_User;
import com.example.ProyectoGalter.Repositorio.Repo_Usuarios;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Service_User {

    private Repo_Usuarios repo_usu;
    private Repo_User repo_user;

    public Service_User(Repo_Usuarios repo_usu, Repo_User repo_user){
        this.repo_usu = repo_usu;
        this.repo_user = repo_user;
    }

    public User crear(User user){
        return repo_user.save(user);
    }

    public User buscarEmail(String email){
        if (repo_user.findById(email).isPresent()){
            return this.repo_user.findById(email).get();
        }else{
            return null;
        }
    }


    public User getCrearUser(Map<String , Object> dataUser){
        String email = (String) dataUser.get("email");
        User user = buscarEmail(email);
        String rol = "";
        if (user == null){
            String nickname = (String) dataUser.get("nickname");
            String img = (String) dataUser.get("picture");
            String auth_id = (String) dataUser.get("sub");
            if(repo_usu.findByCorreoUsuario(email).getTipo_usuario() == 1){
                rol = "admin";
            }else {
                rol = "empleado";
            }
            User novo = new User(email,nickname,img,auth_id,rol);
            return this.crear(novo);
        }else {
            return user;
        }
    }

}
