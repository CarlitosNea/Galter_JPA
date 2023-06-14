package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Entidad.Proveedor;
import com.example.ProyectoGalter.Servicio.Service_Proveedor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Ctrldr_Proveedor {

    private Service_Proveedor servicioP;

    public Ctrldr_Proveedor(Service_Proveedor servicioP){
        this.servicioP = servicioP;
    }


    @GetMapping("/listarProveedores")
    public List<Proveedor> listar_Prov(){
        return servicioP.listar_Prov();
    }


    @GetMapping("/buscarProveedor/{nombre}")
    public Proveedor buscar_Prov(@PathVariable("nombre")String nombre){
        return servicioP.buscar_Prov(nombre);
    }


    @PostMapping("/insertarProveedor")
    public String insertar_Prov(@RequestBody Proveedor prov){
        return servicioP.insertar_Prov(prov);
    }


    @PostMapping("/actualizarProveedor")
    public String actualizar_Prov(@RequestBody Proveedor nuevo_prov){
        return servicioP.update_Prov(nuevo_prov);
    }


    @DeleteMapping("/eliminarProveedor/{nombre}")
    public String eliminar_Prov(@PathVariable("nombre")String nombre){
        return servicioP.eliminar(nombre);
    }


}
