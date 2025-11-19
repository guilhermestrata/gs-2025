# GS Upskilling/Reskilling 2030


Este projeto é uma API RESTful criada para apoiar processos de Upskilling e Reskilling alinhados ao futuro do trabalho, com foco em organização, boas práticas e domínio bem modelado.


## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3+**
- **Maven**
- **MySQL**


## 📁 Estrutura do Projeto
```
src/main/java/
└── com.globalsolution.backend
├── controller
├── service
├── repository
├── exception
└── model


src/main/resources/
├── application.properties
└── data.sql
```


## 📌 Funcionalidades
### ✔ CRUD de Usuários
- Criar usuário
- Listar todos os usuários
- Buscar usuário por ID
- Atualizar usuário
- Deletar usuário


### ✔ CRUD de Trilhas
- Criar trilha
- Listar trilhas
- Buscar trilha por ID
- Atualizar trilha
- Deletar trilha


### ➕ Extra
- Inscrição do usuário em uma trilha
- Listagem de trilhas de um usuário específico


## 🧪 Seeds
O projeto contém um arquivo `data.sql`:
- Usuários iniciais
- Trilhas iniciais


## 🔗 Endpoints Principais
### Usuários
| Método | Rota | Descrição |
|-------|-------|-----------|
| POST | /usuarios | Criar usuário |
| GET | /usuarios | Listar todos |
| GET | /usuarios/{id} | Buscar por ID |
| PUT | /usuarios/{id} | Atualizar |
| DELETE | /usuarios/{id} | Deletar |


### Trilhas
Mesma estrutura de rotas que usuários.

### Inscrição
Mesma estrutura de rotas que usuários.


## ❗ Validações e Exceções
- Campos obrigatórios validados via annotations.
- Exceção customizada `ResourceNotFoundException`.
- Respostas padronizadas de erro.
