package com.cecgil.detector_senhas_vazadas.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cecgil.detector_senhas_vazadas.utils.HashUtils;

import reactor.core.publisher.Mono;

@Service
public class SenhasVazadasService {

    private final WebClient webCliente = WebClient.create("https://api.pwnedpasswords.com/range/");

    public Mono<Boolean> senhaFoiVazada(String senha) throws Exception {
        String sha1Hash = HashUtils.hashSha1(senha).toUpperCase();

        String prefixo = sha1Hash.substring(0, 5);

        String sufixo = sha1Hash.substring(5);

        return webCliente.get()
                         .uri(prefixo)
                         .retrieve()
                         .bodyToMono(String.class)
                         .map(response -> response.contains(sufixo));
    }
    
}
