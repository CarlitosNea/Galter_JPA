package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Material;
import com.example.ProyectoGalter.Entidad.Proveedor;
import com.example.ProyectoGalter.Repositorio.Repo_Material;
import com.example.ProyectoGalter.Repositorio.Repo_Proveedor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Service_Material {

    // Llamado del repositorio
    private Repo_Material repositorio;
    private Repo_Proveedor repo_proveedor;
    public Service_Material(Repo_Material repositorio, Repo_Proveedor repo_proveedor){
        this.repositorio = repositorio;
        this.repo_proveedor = repo_proveedor;
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
    public String insertar_Mate(String prov, Material mate){
        if (repo_proveedor.findById(prov).isPresent()){
            Proveedor Prov = repo_proveedor.findById(prov).get();
            mate.setProveedor_mate(Prov);
            if (repositorio.findById(mate.getCodi_mate()).isPresent())
                return "El codigo del material ya existe";
            else {
                repositorio.save(mate);
                return "Registrado exitosamente";
            }
        }
        else {
            return "Datos de Proveedor mal ingresados";
        }

    }

    // Metodo actualizar
    public String update_Mate(String prov, Material mate){
        if (repo_proveedor.findById(prov).isPresent()){
            Proveedor Prov = repo_proveedor.findById(prov).get();
            mate.setProveedor_mate(Prov);
            if (repositorio.findById(mate.getCodi_mate()).isPresent()){
                repositorio.save(mate);
                return "Actualizado exitosamente";
            }
            else
                return "El material no existe";
        }
        else {
            return "Datos de Proveedor mal ingresados";
        }
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
