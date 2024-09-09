package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.ProdutosRepository;
import com.api_vendinha.api.Infrastructure.repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.ProdutosRequestDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutosResponseDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.Produtos;
import com.api_vendinha.api.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação do serviço de usuários.
 *
 * Esta classe fornece a implementação dos métodos definidos na interface UserServiceInterface,
 * lidando com a lógica de negócios relacionada aos usuários, como criar e atualizar usuários.
 */
@Service
public class ProdutosServiceImpl implements ProdutosServiceInterface {

    // Repositório para a persistência de dados de usuários.
    private final ProdutosRepository produtosRepository;

    /**
     * Construtor para injeção de dependência do UserRepository.
     *
     * @param produtosRepository O repositório de usuários a ser injetado.
     */
    @Autowired
    public ProdutosServiceImpl(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    /**
     * Salva um novo usuário ou atualiza um usuário existente.
     *
     * Cria uma nova entidade User a partir dos dados fornecidos no UserRequestDto, persiste essa
     * entidade no banco de dados, e retorna um UserResponseDto com as informações do usuário salvo.
     *
     * @param produtosRequestDto DTO contendo os dados do usuário a ser salvo ou atualizado.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado e o nome.
     */
    @Override
    public ProdutosResponseDto save(ProdutosRequestDto produtosRequestDto) {
        // Cria uma nova instância de User.
        Produtos produtos = new Produtos();
        // Define o nome do usuário a partir do DTO.
        produtos.setNome(produtosRequestDto.getNome());
        produtos.setQuantidade(produtosRequestDto.getQuantidade());
        produtos.setPreco(produtosRequestDto.getPreco());

        // Salva o usuário no banco de dados e obtém a entidade persistida com o ID gerado.
        Produtos savedProdutos = produtosRepository.save(produtos);

        // Cria um DTO de resposta com as informações do usuário salvo.
        ProdutosResponseDto produtosResponseDto = new ProdutosResponseDto();
        produtosResponseDto.setId(savedProdutos.getId());
        produtosResponseDto.setNome(savedProdutos.getNome());
        produtosResponseDto.setQuantidade(savedProdutos.getQuantidade());
        produtosResponseDto.setPreco(savedProdutos.getPreco());

        // Retorna o DTO com as informações do usuário salvo.
        return produtosResponseDto;
    }

    @Override
    public ProdutosResponseDto update(Long id, ProdutosRequestDto produtosRequestDto){
        Produtos produtosExist = produtosRepository.findById(id).orElseThrow();
        produtosExist.setNome(produtosRequestDto.getNome());
        produtosExist.setQuantidade(produtosRequestDto.getQuantidade());
        produtosExist.setPreco(produtosRequestDto.getPreco());

        produtosRepository.save(produtosExist);

        ProdutosResponseDto produtosResponseDto = new ProdutosResponseDto();
        produtosResponseDto.setId(produtosExist.getId());
        produtosResponseDto.setNome(produtosExist.getNome());
        produtosResponseDto.setQuantidade(produtosExist.getQuantidade());
        produtosResponseDto.setPreco(produtosExist.getPreco());

        return  produtosResponseDto;
    }

    /*
    @Override
    public UserResponseDto buscar(Long id){
        User userExist = userRepository.findById(id).orElseThrow();

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(userExist.getId());
        userResponseDto.setName(userExist.getName());
        userResponseDto.setEmail(userExist.getEmail());
        userResponseDto.setPassword(userExist.getPassword());
        userResponseDto.setIs_active(userExist.getIs_active());
        userResponseDto.setCpf_cnpj(userExist.getCpf_cnpj());

        return  userResponseDto;
    }

    @Override
    public UserResponseDto status(Long id, UserRequestDto userRequestDto){
        User userExist = userRepository.findById(id).orElseThrow();
        userExist.setIs_active(userRequestDto.getIs_active());

        userRepository.save(userExist);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(userExist.getId());
        userResponseDto.setName(userExist.getName());
        userResponseDto.setEmail(userExist.getEmail());
        userResponseDto.setPassword(userExist.getPassword());
        userResponseDto.setIs_active(userExist.getIs_active());
        userResponseDto.setCpf_cnpj(userExist.getCpf_cnpj());

        return  userResponseDto;
    } */
}
