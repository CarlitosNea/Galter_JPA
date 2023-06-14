package com.example.ProyectoGalter.Controlador;


import com.example.ProyectoGalter.Entidad.Producto;
import com.example.ProyectoGalter.Servicio.Service_Producto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Ctrldr_Producto {

    private Service_Producto servicioProd;
    public Ctrldr_Producto(Service_Producto servicioProd){
        this.servicioProd = servicioProd;
    }


    @GetMapping("/listarProductos")
    public List<Producto> listar_Prod(){
        return servicioProd.listar_Prod();
    }


    @GetMapping("/buscarProductoCodigo/{codigo}")
    public Producto buscar_CodiProd(@PathVariable("codigo")String codigo){
        return servicioProd.buscar_CodigoProd(codigo);
    }


    @PostMapping("/insertarProd")
    public String insertar_Prod(@RequestBody Producto prod){
        return servicioProd.insertar_Prod(prod);
    }


    @PostMapping("/actualizarProducto")
    public String actualizar_Prod(@RequestBody Producto prod){
        return servicioProd.update_Prod(prod);
    }


    @DeleteMapping("/eliminarProducto/{codigo}")
    public String eliminar_Prod(@PathVariable("codigo")String codigo){
        return servicioProd.eliminar(codigo);
    }





}
