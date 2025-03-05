package com.cecgil.detector_senhas_vazadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cecgil.detector_senhas_vazadas.services.SenhasVazadasService;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/senhas")
public class SenhasVazadasController {
    
    @Autowired
    private SenhasVazadasService senhasVazadasService;


    @GetMapping("/check")
    public Mono<String> checaSenha(@RequestParam String senha) throws Exception {
        return senhasVazadasService.senhaFoiVazada(senha).map(vazada -> vazada ? "Senha vazada!" : "Senha segura");
    }
    
}
