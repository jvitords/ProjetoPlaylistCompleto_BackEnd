# 🛠️ Backend de Gerenciamento de Listas

Este é o backend da aplicação desenvolvido com **Spring Boot** e **Java 17**, utilizando **H2 (banco de dados em memória)**, autenticação com **Spring Security + JWT**, e testes automatizados com **JUnit** e **Mockito**.

---

## 🔄 Atualizações Recentes

Foram realizadas diversas melhorias no sistema relacionadas à autenticação, permissões e experiência do usuário:

### 1. Roles de Usuário

- O sistema agora diferencia usuários por roles: **USER** e **ADMIN**.
- Cada role possui permissões específicas, garantindo controle de acesso adequado às funcionalidades.

### 2. Acesso à Criação de Usuário

- A página e o botão de cadastro de novos usuários agora **só estão visíveis para usuários com role ADMIN**.
- Usuários comuns (**USER**) não veem a opção, reforçando a segurança e a hierarquia do sistema.

### 3. Sidebar com Nome do Usuário

- O nome do usuário logado agora é exibido na sidebar.
- A informação é carregada automaticamente ao login, usando o endpoint `/me`.

### 4. Botão de Perfil

- O componente de perfil foi implementado e dentro dele temos o botão de redefinir senha e logout.

### 5. Página de Redefinir Senha

- Implementada uma página dedicada para redefinição de senha.
- O campo **username** é exibido automaticamente e **bloqueado para edição**.
- O usuário pode definir uma nova senha de acesso.

Essas melhorias aumentam a segurança do sistema, oferecem uma melhor experiência ao usuário e facilitam a administração das contas.

---

# 🎵 ProvaPlaylistBackEnd - Guia de Inicialização

Bem-vindo! Siga os passos abaixo para rodar a aplicação localmente.

# 1. Clone o repositório

git clone https://github.com/jvitords/ProvaPlaylistBackEnd.git

# 2. Acesse a pasta do projeto

cd ProvaPlaylistBackEnd

# 3. Execute a aplicação

./mvnw spring-boot:run

# 4. Login e Senha

Para acessar a aplicação use o login e senha já configurados para dois tipos de perfis(ADMIN e USER):

ROLE de USER:

- Username: user@gmail.com
- Password: user123

ROLE de ADMIN:

- Username: admin@gmail.com
- Password: admin123

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Banco de Dados H2 (em memória)
- JUnit 5
- Mockito

---

## 🗂️ Funcionalidades da API

**Estes são os endpoints principais que foram pedidos, mas existem outros endpoints adicionais.**

As APIs permitem criar, buscar, atualizar e deletar listas identificadas por nome.

### 📌 Endpoints:

| Método | Rota                | Descrição                      |
| ------ | ------------------- | ------------------------------ |
| POST   | `/lists`            | Cria uma nova lista            |
| GET    | `/lists`            | Retorna todas as listas        |
| GET    | `/lists/{listName}` | Retorna os dados de uma lista  |
| PUT    | `/lists/{listName}` | Atualiza os dados de uma lista |
| DELETE | `/lists/{listName}` | Remove uma lista existente     |

> Todas as rotas protegidas requerem autenticação com JWT (via `Authorization: Bearer <token>`)

---

## 🔒 Segurança

- Autenticação via Spring Security com JWT
- Ao efetuar login, o token JWT é gerado e deve ser usado nas requisições subsequentes

---

## 🧪 Testes

- Os testes unitários foram desenvolvidos com:
  - `JUnit 5`
  - `Mockito`
