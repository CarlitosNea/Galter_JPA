package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Pedido;
import com.example.ProyectoGalter.Repositorio.Repo_Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Pedido {

    private Repo_Pedido repositorio;

    public Service_Pedido(Repo_Pedido repositorio) {
        this.repositorio = repositorio;
    }


    //Metodo listar
    public List<Pedido> listar_pedi() {
        return repositorio.findAll();
    }


    //Buscar por codigo
    public Pedido buscar_idPedi(String id_pedido) {
        if (repositorio.findById(id_pedido).isPresent())
            return repositorio.findById(id_pedido).get();
        else
            return null;
    }


    // Metodo insertar

    public String insertar_pedi(Pedido pedi) {
        if (repositorio.findById(pedi.getId_pedido()).isPresent())
            return "Datos no ingresados";
        else {
            repositorio.save(pedi);
            return "Datos ingersados exitosamente";
        }
    }


    // Metodo actualizar

    public String update_pedi(Pedido pedi){
        if (repositorio.findById(pedi.getId_pedido()).isPresent()){
            repositorio.save(pedi);
            return "Actualizado correctamente";
        }
        else
            return "Datos mal ingerasados";
    }



    //Metodo eliminar
    public String eliminar(String id_pedido){
        if (repositorio.findById(id_pedido).isPresent()){
            repositorio.deleteById(id_pedido);
            return "Eliminado correctamente";
        }
        else
            return "El pedido no existe";
    }




}












