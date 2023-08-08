package com.example.ProyectoGalter.Controlador;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLOutput;

@Controller
public class Ctrldr_Inicio {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            System.out.println(principal.getClaims());
        }
        else {
            System.out.println("Usuario no encontrado");
        }
        return  "index";
    }

    @GetMapping("/productos")
    public String productosPage() {
        return "productos";
    }
}
