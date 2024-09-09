package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutosRequestDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutosResponseDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;

/**
 * Interface que define os serviços relacionados a usuários.
 *
 * Esta interface fornece um contrato para a implementação dos serviços de usuários,
 * especificando os métodos que devem ser fornecidos pelas classes que a implementam.
 */
public interface ProdutosServiceInterface {

    /**
     * Salva um novo usuário ou atualiza um usuário existente.
     *
     * @param produtosRequestDto DTO que contém os dados do usuário a ser salvo ou atualizado.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado e outros detalhes.
     */
    ProdutosResponseDto save(ProdutosRequestDto produtosRequestDto);

    ProdutosResponseDto update(Long id, ProdutosRequestDto produtosRequestDto);
}
