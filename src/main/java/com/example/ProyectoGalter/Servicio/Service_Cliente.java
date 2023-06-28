package com.example.ProyectoGalter.Servicio;

import org.springframework.stereotype.Service;
import com.example.ProyectoGalter.Entidad.Cliente;
import com.example.ProyectoGalter.Repositorio.Repo_Cliente;
import java.util.List;

@Service
public class Service_Cliente {

    private Repo_Cliente repocitorio;
    public Service_Cliente(Repo_Cliente repocitorio){
        this.repocitorio = repocitorio;
    }


    // Metodo listar
    public List<Cliente> listar_cli(){
        return repocitorio.findAll();
    }

    public Cliente buscar_cli(String nombre){
        if (repocitorio.findById(nombre).isPresent())
            return repocitorio.findById(nombre).get();
        else
            return null;
    }

    public String insertar_cli(Cliente cli){
        if (repocitorio.findById(cli.getId_cliente()).isPresent())
            return "El cliente ya existe";
        else{
            repocitorio.save(cli);
            return "Registrado exitosamente";
        }
    }


    public String actualizar_cli(Cliente cli){
        if (repocitorio.findById(cli.getId_cliente()).isPresent()){
            repocitorio.save(cli);
            return "Actualizado correctamente";
        }
        else
            return "El cliente no existe";
    }


    public String eliminar(String codigo){
        if (repocitorio.findById(codigo).isPresent()){
            repocitorio.deleteById(codigo);
            return "Eliminado correctamente";
        }
        else
            return "El cliente no existe";
    }
}