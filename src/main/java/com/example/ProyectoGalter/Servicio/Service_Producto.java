package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Producto;
import com.example.ProyectoGalter.Repositorio.Repo_Producto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Service_Producto {

    // Llamado del repositorio
    private Repo_Producto repositorio;
    public Service_Producto(Repo_Producto repositorio){
        this.repositorio = repositorio;
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
    public String insertar_Prod(Producto prod){
        if (repositorio.findById(prod.getCodi_prod()).isPresent())
            return "Datos mal ingresados";
        else {
            repositorio.save(prod);
            return "Registrado exitosamente";
        }
    }


    // Metodo actualizar
    public String update_Prod(Producto prod){
        if (repositorio.findById(prod.getCodi_prod()).isPresent()){
            repositorio.save(prod);
            return "Actualizado exitosamente";
        }
        else
            return "Datos mal ingresados";

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
