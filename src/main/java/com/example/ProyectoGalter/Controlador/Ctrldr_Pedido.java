package com.example.ProyectoGalter.Controlador;


import com.example.ProyectoGalter.Entidad.Pedido;
import com.example.ProyectoGalter.Servicio.Service_Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Ctrldr_Pedido {

    private Service_Pedido servicioPedi;
    public Ctrldr_Pedido(Service_Pedido servicioPedi){
        this.servicioPedi = servicioPedi;
    }


    @GetMapping("/listarPedido")
    public List<Pedido> listar_Pedi(){
        return servicioPedi.listar_pedi();
    }


    @GetMapping("/buscarPedidoId/{id}")
    public Pedido buscar_idPedido(@PathVariable("id")String id){
        return servicioPedi.buscar_idPedi(id);
    }

/*
    @PostMapping("/insertarPedi")
    public String insertar_Pedi(@RequestBody Pedido pedi){
        return servicioPedi.insertar_pedi(pedi);
    }



    @PostMapping("/actualizarPedido")
    public String actualizar_Pedi(@RequestBody Pedido pedi){
        return servicioPedi.update_pedi(pedi);
    }*/



    @DeleteMapping("/eliminarProducto/{id}")
    public String eliminar_Pedi(@PathVariable("id")String id){
        return servicioPedi.eliminar(id);
    }


}













