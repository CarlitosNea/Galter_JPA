package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Entidad.User;
import com.example.ProyectoGalter.Servicio.Service_User;
import com.example.ProyectoGalter.Servicio.Service_Usuario;
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

    Service_User user_service;
    Service_Usuario usu_service;

    public Ctrldr_Inicio(Service_User user_service, Service_Usuario usu_service){
        this.user_service = user_service;
        this.usu_service = usu_service;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            System.out.println(principal.getClaims());
            User user = this.user_service.getCrearUser(principal.getClaims());
            model.addAttribute("user",user);

            if (user.getRol().equals("admin")){
                return "redirect:/index.html";
            }else{
                return "redirect:/indexE.html";
            }
        }
        else {
            return  "login";
        }

    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
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


    @GetMapping("/indexE")
    public String indexEPage() {
        return "indexE";
    }

    @GetMapping("/productosE")
    public String productosEPage() {
        return "productosE";
    }

    @GetMapping("/clientesE")
    public String clientesEPage() {
        return "clientesE";
    }

    @GetMapping("/materialesE")
    public String materialesEPage() {return "materialesE";}


    @GetMapping("/pedidosE")
    public String pedidosEPage() {
        return "pedidosE";
    }

    @GetMapping("/proveedoresE")
    public String proveedoresEPage() {
        return "proveedoresE";
    }

    @GetMapping("/usuariosE")
    public String usuariosEPage() {
        return "usuariosE";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }



    // Metodos para llamar datos del usuario


}
