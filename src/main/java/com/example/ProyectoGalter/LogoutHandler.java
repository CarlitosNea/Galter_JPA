package com.example.ProyectoGalter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;


@Controller
public class LogoutHandler extends SecurityContextLogoutHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    public LogoutHandler(ClientRegistrationRepository clientRegistrationRepository){
        this.clientRegistrationRepository = clientRegistrationRepository;
    }


    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       Authentication authentication){
        super.logout(httpServletRequest,httpServletResponse,authentication);

        String issuer = (String) getClientRegistration().getProviderDetails().getConfigurationMetadata().get("issuer");
        String clientId = getClientRegistration().getClientId();
        String returnTo = ServletUriComponentsBuilder.fromCurrentContextPath().build().toString();

        String logoutUrl = UriComponentsBuilder
                .fromHttpUrl(issuer + "v2/logout?client_id=gjKUfA8tXSUF87p7ekS2xK4gJxMbOuFF&returnTo=http://localhost:8080/login2")
                .encode()
                .buildAndExpand(clientId, returnTo)
                .toUriString();

        log.info("Will attempt to redirect to logout URL: {}", logoutUrl);
        try{
            httpServletResponse.sendRedirect(logoutUrl);
        } catch (IOException ioe){
            log.error("Error redirecting to logout URL", ioe);
        }
    }

    private ClientRegistration getClientRegistration(){
        return this.clientRegistrationRepository.findByRegistrationId("auth0");
    }
}
