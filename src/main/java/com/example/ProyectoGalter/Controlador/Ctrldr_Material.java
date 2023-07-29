package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Entidad.Material;
import com.example.ProyectoGalter.Servicio.Service_Material;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Ctrldr_Material {

    private Service_Material servicioM;
    public Ctrldr_Material(Service_Material servicioM){
        this.servicioM = servicioM;
    }


    @GetMapping("/listarMaterial")
    public List<Material> listar_Mate(){
        return servicioM.listar_Mat();
    }


    @GetMapping("/buscarMaterialCodigo/{codigo}")
    public Material buscar_CodiMate(@PathVariable("codigo")String codigo){
        return servicioM.buscar_CodigoMate(codigo);
    }


    @PostMapping("/insertarMaterial/{prov}")
    public String insertar_Mate(@PathVariable("prov")String prov, @RequestBody Material mate){
        return servicioM.insertar_Mate(prov, mate);
    }

    @PutMapping("/actualizarMaterial/{prov}")
    public String actualizar_Mate(@PathVariable("prov")String prov, @RequestBody Material mate){
        return servicioM.update_Mate(prov, mate);
    }

    @DeleteMapping("/eliminarMaterial/{codigo}")
    public String eliminar_Mate(@PathVariable("codigo")String codigo){
        return servicioM.eliminar(codigo);
    }




}
