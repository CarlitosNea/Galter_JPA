package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Entidad.User;
import com.example.ProyectoGalter.Servicio.Service_User;
import com.example.ProyectoGalter.Servicio.Service_Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class Ctrldr_Inicio {

    Service_User user_service;
    Service_Usuario usu_service;

    public Ctrldr_Inicio(Service_Usuario usu_service, Service_User user_service){
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
            return "redirect:/login";
        }

    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/http://localhost:8080/oauth2/authorization/auth0";
    }

}
