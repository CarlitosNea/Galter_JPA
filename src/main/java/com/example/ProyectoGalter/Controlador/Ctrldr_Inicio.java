package com.example.ProyectoGalter.Controlador;

import ch.qos.logback.core.model.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Ctrldr_Inicio {
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            System.out.println(principal.getClaims());
        }
        else {
            System.out.println("Usuario no encontrado");
        }
        return "index";
    }

    @GetMapping("/productos")
    public String productosPage() {
        return "productos";
    }
}