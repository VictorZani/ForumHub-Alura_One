-- Migration para criar as tabelas principais

-- Tabela de Usuários
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Tabela de Cursos
CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

-- Tabela de Tópicos
CREATE TABLE topicos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL CHECK (estado IN ('ABERTO', 'FECHADO', 'RESOLVIDO')),
    autor_id INT NOT NULL,
    curso_id INT NOT NULL,
    CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES usuarios (id) ON DELETE CASCADE,
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos (id) ON DELETE CASCADE
);
