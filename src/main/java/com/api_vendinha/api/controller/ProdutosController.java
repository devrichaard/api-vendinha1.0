package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.ProdutosRequestDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutosResponseDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.service.ProdutosServiceInterface;
import com.api_vendinha.api.domain.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gerenciar operações relacionadas aos usuários.
 */
@RestController
@RequestMapping("/api") // Define o caminho base para as requisições deste controlador.
public class ProdutosController {

    // Injeção de dependência do serviço de usuários.
    private final ProdutosServiceInterface produtosService;

    /**
     * Construtor para injeção de dependência do serviço de usuários.
     *
     * @param produtosService O serviço de usuários a ser injetado.
     */
    @Autowired
    public ProdutosController(ProdutosServiceInterface produtosService) {
        this.produtosService = produtosService;
    }

    /**
     * Método para salvar um novo usuário.
     *
     * @param produtosRequestDto DTO que contém os dados do usuário a ser salvo.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado.
     */
    @PostMapping("/produtos") // Define que este método lida com requisições HTTP POST.
    public ProdutosResponseDto salvar(@RequestBody ProdutosRequestDto produtosRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return produtosService.save(produtosRequestDto);
    }

    @PutMapping("/produtos/{id}") // Define que este método lida com requisições HTTP POST.
    public ProdutosResponseDto update(@PathVariable Long id, @RequestBody ProdutosRequestDto produtosRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return produtosService.update(id, produtosRequestDto);
    }
/*
    @GetMapping("/usuario/{id}") // Define que este método lida com requisições HTTP POST.
    public UserResponseDto buscar(@PathVariable Long id) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return userService.buscar(id);
    }

    @PutMapping("/usuario/{id}/status") // Define que este método lida com requisições HTTP POST.
    public UserResponseDto status(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return userService.status(id, userRequestDto);
    }*/
}
