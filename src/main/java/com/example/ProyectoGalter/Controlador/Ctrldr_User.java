package com.example.ProyectoGalter.Controlador;

import com.example.ProyectoGalter.Entidad.User;
import com.example.ProyectoGalter.Servicio.Service_User;
import com.example.ProyectoGalter.Servicio.Service_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Ctrldr_User {

    Service_User user_service;
    Service_Usuario usu_service;

    public Ctrldr_User (Service_User user_service, Service_Usuario usu_service){
        this.user_service = user_service;
        this.usu_service = usu_service;
    }

    @GetMapping("/user")
    @ResponseBody
    public User user(@AuthenticationPrincipal OidcUser principal){
        System.out.println(principal.getClaims());
        String email = (String) principal.getClaims().get("email");
        User user = this.user_service.buscarEmail(email);
        return user;
    }


}
