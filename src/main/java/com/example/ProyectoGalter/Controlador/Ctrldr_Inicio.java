package com.example.ProyectoGalter.Controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;


@Controller
public class  Ctrldr_Inicio {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            System.out.println(principal.getClaims());
        }
        else {
            System.out.println("Usuario no encontrado");
        }
        return  "index2";
    }

    @GetMapping("/index2")
    public String index2Page() {
        return "index2";
    }

    @GetMapping("/productos")
    public String productosPage() {
        return "productos";
    }

    @GetMapping("/clientes")
    public String clientesPage() {
        return "clientes";
    }

    @GetMapping("/materiales")
    public String materialesPage() {return "materiales";}


    @GetMapping("/pedidos")
    public String pedidosPage() {
        return "pedidos";
    }

    @GetMapping("/proveedores")
    public String proveedoresPage() {
        return "proveedores";
    }

    @GetMapping("/usuarios")
    public String usuariosPage() {
        return "usuarios";
    }



    // Metodos para llamar datos del usuario


}
