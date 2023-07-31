package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.*;
import com.example.ProyectoGalter.Repositorio.Repo_Cliente;
import com.example.ProyectoGalter.Repositorio.Repo_Pedido;
import com.example.ProyectoGalter.Repositorio.Repo_Producto;
import com.example.ProyectoGalter.Repositorio.Repo_Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Service_Pedido {

    // Llamado del repositorio
    private Repo_Pedido repositorio;
    private Repo_Producto repo_prod;
    private Repo_Cliente repo_cli;
    private Repo_Usuarios repo_usu;
    public Service_Pedido(Repo_Pedido repositorio, Repo_Producto repo_prod, Repo_Cliente repo_cli, Repo_Usuarios repo_usu){
        this.repositorio = repositorio;
        this.repo_cli = repo_cli;
        this.repo_prod = repo_prod;
        this.repo_usu = repo_usu;
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

    public String insertar_Ped(String cli, String prod, String usu, Pedido ped){
        if (repo_cli.findById(cli).isPresent() && repo_prod.findById(prod).isPresent() && repo_usu.findById(usu).isPresent()){
            Cliente Cli = repo_cli.findById(cli).get();
            Producto Prod = repo_prod.findById(prod).get();
            Usuario Usu = repo_usu.findById(usu).get();
            ped.setCliente_ped(Cli);
            ped.setProducto_ped(Prod);
            ped.setUsuario_ped(Usu);
            repositorio.save(ped);
            return "Registrado exitosamente";
        }
        else {
            return "Cliente, Producto o Usuario mal ingresado";
        }

    }


    // Metodo actualizar
    public String update_Ped(String cli, String prod, String usu, Pedido ped){
        if (repo_cli.findById(cli).isPresent() && repo_prod.findById(prod).isPresent() && repo_usu.findById(usu).isPresent()){
            Cliente Cli = repo_cli.findById(cli).get();
            Producto Prod = repo_prod.findById(prod).get();
            Usuario Usu = repo_usu.findById(usu).get();
            ped.setCliente_ped(Cli);
            ped.setProducto_ped(Prod);
            ped.setUsuario_ped(Usu);
            if (repositorio.findById(String.valueOf(ped.getId_pedido())).isPresent()){
                repositorio.save(ped);
                return "Actualizado exitosamente";
            }
            else
                return "El pedido no existe";
        }
        else {
            return "Cliente, Producto o Usuario mal ingresado";
        }
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
