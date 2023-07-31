package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Material;
import com.example.ProyectoGalter.Entidad.Producto;
import com.example.ProyectoGalter.Entidad.Proveedor;
import com.example.ProyectoGalter.Repositorio.Repo_Material;
import com.example.ProyectoGalter.Repositorio.Repo_Producto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Service_Producto {

    // Llamado del repositorio
    private Repo_Producto repositorio;
    private Repo_Material repo_material;
    public Service_Producto(Repo_Producto repositorio, Repo_Material repo_material){
        this.repositorio = repositorio;
        this.repo_material = repo_material;
    }


    // Metodo listar
    public List<Producto> listar_Prod(){
        return repositorio.findAll();
    }


    // Buscar por codigo
    public Producto buscar_CodigoProd(String codi_prod){
        if (repositorio.findById(codi_prod).isPresent())
            return repositorio.findById(codi_prod).get();
        else
            return null;
    }


    // Metodo insertar

    public String insertar_Prod(String mate, Producto prod){
        if (repo_material.findById(mate).isPresent()){
            Material Mate = repo_material.findById(mate).get();
            prod.setMaterial_prod(Mate);
            if (repositorio.findById(prod.getCodi_prod()).isPresent())
                return "El codigo del producto ya existe";
            else {
                repositorio.save(prod);
                return "Registrado exitosamente";
            }
        }
        else {
            return "Datos de Material mal ingresados";
        }

    }


    // Metodo actualizar
    public String update_Prod(String mate, Producto prod){
        if (repo_material.findById(mate).isPresent()){
            Material Mate = repo_material.findById(mate).get();
            prod.setMaterial_prod(Mate);
            if (repositorio.findById(prod.getCodi_prod()).isPresent()){
                repositorio.save(prod);
                return "Actualizado exitosamente";
            }
            else
                return "El producto no existe";
        }
        else {
            return "Datos deL Material mal ingresados";
        }
    }


    // Metodo eliminar
    public String eliminar(String codi_prod){
        if (repositorio.findById(codi_prod).isPresent()){
            repositorio.deleteById(codi_prod);
            return "Eliminado exitosamente";
        }
        else
            return "El producto no existe";
    }

}
