package com.example.demo.controller.OAuth2Controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OAuth2Controller {

    @GetMapping("/")
    public Object  securityFilterChain(OAuth2AuthenticationToken auth2AuthenticationToken){
        Collection<? extends GrantedAuthority> authorities = auth2AuthenticationToken.getAuthorities();

        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return auth2AuthenticationToken.getPrincipal().getAuthorities();
    }

}
