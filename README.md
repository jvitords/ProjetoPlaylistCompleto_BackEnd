# 🛠️ Backend de Gerenciamento de Listas

Este é o backend da aplicação desenvolvido com **Spring Boot** e **Java 17**, utilizando **H2 (banco de dados em memória)**, autenticação com **Spring Security + JWT**, e testes automatizados com **JUnit** e **Mockito**.

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

# 1. Clone o repositório

git clone https://github.com/jvitords/ProvaPlaylistBackEnd.git

# 2. Acesse a pasta do projeto

cd ProvaPlaylistBackEnd

# 3. Execute a aplicação

./mvnw spring-boot:run

# 4. Login e Senha

Para acessar a aplicação use o login e senha já configurados:

- Username: user@gmail.com
- Password: user123
