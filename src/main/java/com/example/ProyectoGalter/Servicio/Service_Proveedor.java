package com.example.ProyectoGalter.Servicio;


import com.example.ProyectoGalter.Entidad.Proveedor;
import com.example.ProyectoGalter.Repositorio.Repo_Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Proveedor {

    // Llamado del repositorio
    private Repo_Proveedor repositorio;
    public Service_Proveedor(Repo_Proveedor repositorio){
        this.repositorio = repositorio;
    }


    // Metodo listar
    public List<Proveedor> listar_Prov(){
        return repositorio.findAll();
    }


    // Metodo buscar
    public Proveedor buscar_Prov(String nombre){
        if (repositorio.findById(nombre).isPresent())
            return repositorio.findById(nombre).get();
        else
            return null;
    }


    // Metodo insertar
    public String insertar_Prov(Proveedor prov){
        if (repositorio.findById(prov.getNombre_proveedor()).isPresent())
            return "El Proveedor ya existe";
        else{
            repositorio.save(prov);
            return "Registrado exitosamente";
        }
    }


    // Metodo actualizar
    public String update_Prov(Proveedor prov){
        if (repositorio.findById(prov.getNombre_proveedor()).isPresent()){
            repositorio.save(prov);
            return "Actualizado exitosamente";
        }
        else
            return "El proveedor no existe";

    }


    // Metodo eliminar
    public String eliminar(String nombre){
        if (repositorio.findById(nombre).isPresent()){
            repositorio.deleteById(nombre);
            return "Eliminado exitosamente";
        }
        else
            return "El proveedor no existe";
    }



}
