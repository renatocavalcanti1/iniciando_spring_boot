package com.example.Aprendendo.service;

import org.springframework.stereotype.Service;

import com.example.Aprendendo.repository.MensagemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MensagemService {
    
    private final MensagemRepository mensagemRepository;
    

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }
}
