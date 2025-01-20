# FórumHub 

A API FórumHub é uma aplicação desenvolvida com Spring Boot que permite a criação, leitura, atualização e exclusão de tópicos em um fórum. A autenticação é gerenciada por tokens JWT para garantir a segurança das operações.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Security 6**
- **JWT (JSON Web Token)**
- **Banco de Dados**: [Especificar o banco de dados utilizado]

## Funcionalidades

- **Cadastro de Usuário**: Permite que novos usuários se registrem na plataforma.
- **Login de Usuário**: Usuários podem autenticar-se utilizando suas credenciais.
- **Gerenciamento de Tópicos**:
  - **Criar**: Usuários autenticados podem criar novos tópicos.
  - **Ler**: Visualizar tópicos existentes.
  - **Atualizar**: Editar tópicos próprios.
  - **Excluir**: Remover tópicos próprios.

## Endpoints

### Autenticação

- **POST /login**:
  - **Descrição**: Autentica o usuário e retorna um token JWT.
  - **Corpo da Requisição**:
    ```json
    {
      "email": "usuario@exemplo.com",
      "senha": "senha@123"
    }
    ```
  - **Resposta**:
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```

### Tópicos

- **GET /topicos**:
  - **Descrição**: Retorna uma lista de tópicos.
  - **Cabeçalho**:
    ```
    Authorization: Bearer {token}
    ```
  - **Resposta**:
    ```json
    [
      {
        "id": 1,
        "titulo": "Como implementar autenticação JWT?",
        "conteudo": "Detalhes sobre a implementação...",
        "autor": "usuario@exemplo.com"
      },
      ...
    ]
    ```

- **POST /topicos**:
  - **Descrição**: Cria um novo tópico.
  - **Cabeçalho**:
    ```
    Authorization: Bearer {token}
    ```
  - **Corpo da Requisição**:
    ```json
    {
      "titulo": "Novo Tópico",
      "conteudo": "Conteúdo do tópico..."
    }
    ```
  - **Resposta**:
    ```json
    {
      "id": 2,
      "titulo": "Novo Tópico",
      "conteudo": "Conteúdo do tópico...",
      "autor": "usuario@exemplo.com"
    }
    ```
