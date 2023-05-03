package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Material;
import com.example.ProyectoGalter.Repositorio.Repo_Material;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Service_Material {

    // Llamado del repositorio
    private Repo_Material repositorio;
    public Service_Material(Repo_Material repositorio){
        this.repositorio = repositorio;
    }


    // Metodo listar
    public List<Material> listar_Mat(){
        return repositorio.findAll();
    }


    // Buscar por codigo
    public Material buscar_CodigoMate(String codi_mate){
        if (repositorio.findById(codi_mate).isPresent())
            return repositorio.findById(codi_mate).get();
        else
            return null;
    }


    // Metodo insertar
    public String insertar_Mate(Material mate){
        if (repositorio.findById(mate.getCodi_mate()).isPresent())
            return "Datos mal ingresados";
        else {
            repositorio.save(mate);
            return "Registrado exitosamente";
        }
    }


    // Metodo actualizar
    public String update_Mate(Material mate){
        if (repositorio.findById(mate.getCodi_mate()).isPresent()){
            repositorio.save(mate);
            return "Actualizado exitosamente";
        }
        else
            return "Datos mal ingresados";

    }


    // Metodo eliminar
    public String eliminar(String codi_Mate){
        if (repositorio.findById(codi_Mate).isPresent()){
            repositorio.deleteById(codi_Mate);
            return "Eliminado exitosamente";
        }
        else
            return "El material no existe";
    }



}
