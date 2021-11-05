package com.example.Bored.controllers;

import com.example.Bored.models.UsuarioModel;
import com.example.Bored.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public Flux<UsuarioModel> getAllUser(){
        return usuarioService.getAllUser();
    }

    @GetMapping(path = "/{id}")
    public Mono<UsuarioModel> getUser(@PathVariable("id") Long id ){
        return usuarioService.getUser(id);
    }

    @PostMapping()
    public Mono<UsuarioModel> addUser(@RequestBody UsuarioModel usuario){
        return usuarioService.addUser(usuario);
    }
}
