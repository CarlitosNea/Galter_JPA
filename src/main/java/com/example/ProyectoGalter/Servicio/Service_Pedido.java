package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Pedido;
import com.example.ProyectoGalter.Repositorio.Repo_Pedido;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Service_Pedido {

    // Llamado del repositorio
    private Repo_Pedido repositorio;
    public Service_Pedido(Repo_Pedido repositorio){
        this.repositorio = repositorio;
    }


    // Metodo listar
    public List<Pedido> listar_Ped(){
        return repositorio.findAll();
    }


    // Buscar por codigo
    public Pedido buscar_CodigoPed(String id_pedido){
        if (repositorio.findById(id_pedido).isPresent())
            return repositorio.findById(id_pedido).get();
        else
            return null;
    }


    // Metodo insertar
    public String insertar_Ped(Pedido ped){
        if (repositorio.findById(ped.getId_pedido()).isPresent())
            return "Datos mal ingresados";
        else {
            repositorio.save(ped);
            return "Registrado exitosamente";
        }
    }


    // Metodo actualizar
    public String update_Ped(Pedido ped){
        if (repositorio.findById(ped.getId_pedido()).isPresent()){
            repositorio.save(ped);
            return "Actualizado exitosamente";
        }
        else
            return "Datos mal ingresados";

    }


    // Metodo eliminar
    public String eliminar(String id_pedido){
        if (repositorio.findById(id_pedido).isPresent()){
            repositorio.deleteById(id_pedido);
            return "Eliminado exitosamente";
        }
        else
            return "El material no existe";
    }
}
