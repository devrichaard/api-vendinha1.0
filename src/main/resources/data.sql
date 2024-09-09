CREATE TABLE USERS (
        ID INTEGER PRIMARY KEY AUTO_INCREMENT,  -- Coluna ID é a chave primária, do tipo INTEGER, e será auto-incrementada automaticamente pelo banco de dados.
        NAME VARCHAR(255),                      -- Coluna NAME armazena o nome do usuário, com um máximo de 255 caracteres.]
        EMAIL VARCHAR(255),
        PASSWORD VARCHAR (50),
        IS_ACTIVE BOOLEAN DEFAULT TRUE,
        CPF_CNPJ CHAR (11)
);

CREATE TABLE PRODUTOS (
        ID INTEGER PRIMARY KEY AUTO_INCREMENT,
        NOME VARCHAR(255),
        QUANTIDADE INTEGER,
        PRECO DECIMAL(5,2)
);
