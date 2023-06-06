package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Entidad.Pedido;
import com.example.ProyectoGalter.Servicio.Service_Pedido;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Ctrldr_Pedido {
    private Service_Pedido servicioP;
    public Ctrldr_Pedido(Service_Pedido servicioP){
        this.servicioP = servicioP;
    }


    @GetMapping("/listarPedido")
    public List<Pedido> listar_Ped(){
        return servicioP.listar_Ped();
    }


    @GetMapping("/buscarPedidoCodigo/{codigo}")
    public Pedido buscar_CodiPed(@PathVariable("codigo")String id_pedido){
        return servicioP.buscar_CodigoPed(id_pedido);
    }


    @PostMapping("/insertarPedido")
    public String insertar_Ped(@RequestBody Pedido ped){
        return servicioP.insertar_Ped(ped);
    }

    @PostMapping("/actualizarPedido")
    public String actualizar_Ped(@RequestBody Pedido ped){
        return servicioP.update_Ped(ped);
    }

    @DeleteMapping("/eliminarPedido/{codigo}")
    public String eliminar_Ped(@PathVariable("codigo")String id_pedido){
        return servicioP.eliminar(id_pedido);
    }
}
