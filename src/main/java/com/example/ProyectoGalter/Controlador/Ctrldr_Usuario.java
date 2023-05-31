package com.example.proyecto_galter.controlador;


import com.example.proyecto_galter.entidad.Usuario;
import com.example.proyecto_galter.servicios.Service_Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ctrldr_Usuario {

    private Service_Usuario serviciosU;

    public Ctrldr_Usuario(Service_Usuario serviciosU) {
        this.serviciosU = serviciosU;
    }

    @GetMapping("/listarUsuarios")
    public List<Usuario> listar_usu(){
        return serviciosU.listar_usu();
    }


    @GetMapping("/buscarUsuario/{nombre}")
    public Usuario buscar_usu(@PathVariable("nombre")String nombre){
        return serviciosU.buscar_usu(nombre);
    }


    @PostMapping("/insertarUsusario")
    public String insertar_usu(@RequestBody Usuario usu){
        return serviciosU.insertar_usu(usu);
    }


    @PostMapping("/actualizarUsuario")
    public String actualiazar_usu(@RequestBody Usuario usu){
        return serviciosU.actualizar_usu(usu);
    }


    @DeleteMapping("/eliminarUsuario/{nombre}")
    public String eliminar_usu(@PathVariable("nombre")String nombre){
        return serviciosU.eliminar(nombre);
    }


}
