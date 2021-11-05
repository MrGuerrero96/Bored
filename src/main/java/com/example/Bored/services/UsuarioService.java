package com.example.Bored.services;

import com.example.Bored.models.UsuarioModel;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {

    private final WebClient webClient;

    public UsuarioService(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<UsuarioModel> addUser(UsuarioModel usuario){
        System.out.println("prueba");
        return this.webClient.post()
                .uri("/usuario")
                .bodyValue(usuario)
                .retrieve()
                .bodyToMono(UsuarioModel.class);
    }

    public Flux<UsuarioModel> getAllUser(){
        return this.webClient.get()
                .uri("usuario")
                .retrieve()
                .bodyToFlux(UsuarioModel.class);
    }

    public Mono<UsuarioModel> getUser(Long id){
        return this.webClient.get()
                .uri("usuario/" + id)
                .retrieve()
                .bodyToMono(UsuarioModel.class);
    }
}
