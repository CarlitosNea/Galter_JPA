package com.example.ProyectoGalter.Servicio;

import com.example.ProyectoGalter.Entidad.Producto;
import com.example.ProyectoGalter.Repositorio.Repo_Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Service_Calculadora {

    private Repo_Producto repo_prod;
    public Service_Calculadora(Repo_Producto repo_prod) {
        this.repo_prod = repo_prod;
    }

    public ArrayList calculo(String codi_prod, int cant_piezas){
        ArrayList datos = new ArrayList<>();
        System.out.println(codi_prod);
        if (repo_prod.findById(codi_prod).isPresent()){
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Producto prod = repo_prod.findById(codi_prod).get();
            System.out.println(prod);
            String codi_mate = prod.getMaterial_prod();
            datos.add(codi_mate);
            System.out.println(codi_mate);

            float long_prod = prod.getLong_prod()/100;
            float cant_mate = long_prod * cant_piezas;
            datos.add(cant_mate);

            int tiempo = prod.getTiempo_prod()*cant_piezas;
            String info_tiempo;
            if (tiempo > 60 && tiempo < 3600){
                int minutos = tiempo / 60;
                int segundos = tiempo - (minutos * 60);
                info_tiempo = minutos+" minutos y "+segundos+" segundos";
                datos.add(info_tiempo);
            } else if (tiempo > 3600) {
                int horas = tiempo / 3600;
                int minutos = (tiempo - (horas * 3600)) / 60;
                int segundos = tiempo - ((minutos * 60) + (horas * 3600));
                info_tiempo = horas+" horas, "+minutos+" minutos y "+segundos+" segundos";
                datos.add(info_tiempo);
            }


            int valor_total = prod.getPrec_prod() * cant_piezas;
            datos.add(valor_total);

            System.out.println(datos);
            return datos;
        }
        else {
            System.out.println("ERROR EN LOS DATOS");
            return datos;
        }
    }
}
