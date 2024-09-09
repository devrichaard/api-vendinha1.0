package com.api_vendinha.api.domain.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutosResponseDto {
    private Long id;
    private String nome;
    private Integer quantidade;
    private Float preco;
}