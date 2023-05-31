package com.example.ProyectoGalter.Controlador;
import com.example.ProyectoGalter.Entidad.Cliente;
import com.example.ProyectoGalter.Servicio.Service_Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ctrldr_Cliente {

    private Service_Cliente serviciosC;
    public Ctrldr_Cliente(Service_Cliente serviciosC) {
        this.serviciosC = serviciosC;
    }


    @GetMapping("/listarCliente")
    public List<Cliente> listar_cli(){
        return serviciosC.listar_cli();
    }


    @GetMapping("/buscarCliente/{nombre}")
    public Cliente buscar_cli(@PathVariable("nombre")String nombre){
        return serviciosC.buscar_cli(nombre);
    }


    @PostMapping("/insertarCliente")
    public String insertar_cli(@RequestBody Cliente cli){
        return serviciosC.insertar_cli(cli);
    }


    @PostMapping("/actualizarCliente")
    public String actualiazar_cli(@RequestBody Cliente cli){
        return serviciosC.actualizar_cli(cli);
    }


    @DeleteMapping("/eliminarCliente/{nombre}")
    public String eliminar_cli(@PathVariable("nombre")String nombre){
        return serviciosC.eliminar(nombre);
    }


}
