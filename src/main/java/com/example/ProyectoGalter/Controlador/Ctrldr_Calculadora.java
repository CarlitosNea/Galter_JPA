package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Servicio.Service_Calculadora;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Ctrldr_Calculadora {
    private Service_Calculadora servicioC;
    public Ctrldr_Calculadora(Service_Calculadora servicioC){
        this.servicioC = servicioC;
    }

    @GetMapping("/calculadora/{codi_prod}/{cant_piezas}")
    public ArrayList calculo(@PathVariable("codi_prod") String codi_prod, @PathVariable("cant_piezas") int cant_piezas){
        return servicioC.calculo(codi_prod,cant_piezas);
    }
}
