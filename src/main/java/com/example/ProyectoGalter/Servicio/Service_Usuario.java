package com.example.proyecto_galter.servicios;
import com.example.proyecto_galter.entidad.Usuario;
import com.example.proyecto_galter.repocitorios.Repo_Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Usuario {

    private Repo_Usuarios repocitorio;
    public Service_Usuario(Repo_Usuarios repocitorio){
        this.repocitorio = repocitorio;
    }

    public List<Usuario> listar_usu(){
        return repocitorio.findAll();
    }

    public Usuario buscar_usu(String nombre){
        if (repocitorio.findById(nombre).isPresent())
            return repocitorio.findById(nombre).get();
        else
            return null;
    }

    public String insertar_usu(Usuario usu){
        if (repocitorio.findById(usu.getNombre_usuario()).isPresent())
            return "El usuario ya existe";
        else{
            repocitorio.save(usu);
            return "Registrado exitosamente";
        }
    }


    public String actualizar_usu(Usuario usu){
        if (repocitorio.findById(usu.getNombre_usuario()).isPresent()){
            repocitorio.save(usu);
            return "Actualizado correctamente";
        }
        else
            return "El usuario no existe";
    }


    public String eliminar(String nombre){
        if (repocitorio.findById(nombre).isPresent()){
            repocitorio.deleteById(nombre);
            return "Eliminado correctamente";
        }
        else
            return "El usuario no existe";
    }



}
