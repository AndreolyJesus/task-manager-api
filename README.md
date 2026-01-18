# 📋 Task Manager API

Uma **API RESTful profissional** para gerenciamento de tarefas e usuários. Desenvolvida com **Spring Boot 3**, **Spring Data JPA** e **Banco H2**. Ideal para portfólio, demonstrando boas práticas de desenvolvimento backend em Java.

---

## 🎯 Características Principais

✅ **CRUD Completo** - Criar, ler, atualizar e deletar tarefas e usuários  
✅ **Filtros Avançados** - Pesquisar por título, filtrar por status  
✅ **Toggle de Status** - Alternar entre concluída/pendente com PATCH  
✅ **Persistência em BD** - Banco H2 com criação automática de tabelas  
✅ **Logs Estruturados** - SQL formatado para fácil debug  
✅ **CORS Habilitado** - Pronto para integrar com frontend  
✅ **Validações de Entrada** - Com @Valid e @NotBlank  

---

## 🛠️ Stack Tecnológico

| Tecnologia | Versão | Uso |
|-----------|--------|-----|
| **Java** | 17+ | Linguagem principal |
| **Spring Boot** | 3.x | Framework web |
| **Spring Data JPA** | 3.x | Persistência e ORM |
| **Hibernate** | 6.x | Mapeamento objeto-relacional |
| **H2 Database** | 2.x | Banco de dados embarcado |
| **Maven** | 3.8+ | Build e dependências |

---

## 📦 Arquitetura do Projeto

```
task-api/
├── src/main/java/com/taskmanager/task_api/
│   ├── controller/
│   │   ├── TaskController.java
│   │   └── UsuarioController.java
│   ├── model/
│   │   ├── Task.java
│   │   └── Usuario.java
│   ├── repository/
│   │   ├── TaskRepository.java
│   │   └── UsuarioRepository.java
│   ├── service/
│   │   ├── TaskService.java
│   │   └── UsuarioService.java
│   └── TaskApiApplication.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
├── README.md
└── . gitignore
```

---

## 🚀 Quick Start

### Pré-requisitos
- Java 17+ ([Download Adoptium](https://adoptium.net/))
- Maven 3.8+ ([Download](https://maven.apache.org/))

### 1️⃣ Clone e Configure
```bash
git clone https://github.com/AndreolyJesus/task-manager-api.git
cd task-manager-api
```

### 2️⃣ Build e Run
```bash
mvn clean install
mvn spring-boot:run
```

### 3️⃣ Acesse a API
- **API**:  http://localhost:8081/api/tasks
- **Console H2**: http://localhost:8081/h2-console
  - JDBC URL: `jdbc:h2:file:./data/taskdb`
  - User: `oly`
  - Password: (deixe em branco)

---

## 🔌 Endpoints da API

### 📌 Tarefas (`/api/tasks`)

#### ✨ Criar Tarefa
```http
POST /api/tasks
Content-Type: application/json

{
  "title": "Implementar autenticação",
  "description": "Adicionar JWT ao projeto",
  "completed": false
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "title": "Implementar autenticação",
  "description":  "Adicionar JWT ao projeto",
  "completed": false,
  "createdAt": "2026-01-18T10:30:00"
}
```

---

#### 📖 Listar Todas as Tarefas
```http
GET /api/tasks
```

**Resposta (200 OK):**
```json
[
  {
    "id":  1,
    "title":  "Implementar autenticação",
    "description": "Adicionar JWT ao projeto",
    "completed": false
  },
  {
    "id": 2,
    "title": "Deploy em produção",
    "description":  "Publicar na AWS",
    "completed": true
  }
]
```

---

#### 🔍 Filtrar por Status
```http
GET /api/tasks?completed=true
```

---

#### 🔎 Pesquisar por Título
```http
GET /api/tasks?search=autenticação
```

---

#### 🎯 Buscar Tarefa por ID
```http
GET /api/tasks/1
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "title": "Implementar autenticação",
  "description":  "Adicionar JWT ao projeto",
  "completed": false
}
```

---

#### ✏️ Atualizar Tarefa
```http
PUT /api/tasks/1
Content-Type: application/json

{
  "title": "Implementar autenticação com JWT",
  "description": "Adicionar JWT e refresh token",
  "completed": false
}
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "title": "Implementar autenticação com JWT",
  "description":  "Adicionar JWT e refresh token",
  "completed":  false
}
```

---

#### 🔄 Alternar Status (Concluída/Pendente)
```http
PATCH /api/tasks/1/toggle
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "title": "Implementar autenticação",
  "completed": true
}
```

---

#### 🗑️ Deletar Tarefa
```http
DELETE /api/tasks/1
```

**Resposta (204 No Content)**

---

## 💡 Exemplos com cURL

### Criar Tarefa
```bash
curl -X POST http://localhost:8081/api/tasks \
  -H "Content-Type:  application/json" \
  -d '{
    "title": "Minha primeira tarefa",
    "description":  "Uma descrição da tarefa",
    "completed": false
  }'
```

### Listar Todas
```bash
curl http://localhost:8081/api/tasks
```

### Buscar por ID
```bash
curl http://localhost:8081/api/tasks/1
```

### Alternar Status
```bash
curl -X PATCH http://localhost:8081/api/tasks/1/toggle
```

### Deletar
```bash
curl -X DELETE http://localhost:8081/api/tasks/1
```

---

## 📊 Banco de Dados

### Tabela:  TASK

| Coluna | Tipo | Restrições |
|--------|------|-----------|
| `id` | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| `title` | VARCHAR(255) | NOT NULL |
| `description` | TEXT | NULL |
| `completed` | BOOLEAN | DEFAULT false |
| `created_at` | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

### Tabela: USUARIO

| Coluna | Tipo | Restrições |
|--------|------|-----------|
| `id` | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| `nome` | VARCHAR(100) | NOT NULL |
| `data_nascimento` | DATE | NOT NULL |

---

## ⚙️ Configuração (application.properties)

```properties
# ============= BANCO DE DADOS H2 =============
spring.datasource.url=jdbc:h2:file:./data/taskdb
spring.datasource. driverClassName=org.h2.Driver
spring.datasource.username=oly
spring.datasource.password=

# ============= CONSOLE H2 =============
spring. h2.console.enabled=true
spring.h2.console.path=/h2-console

# ============= JPA / HIBERNATE =============
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring. jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate. format_sql=true

# ============= SERVIDOR =============
server.port=8081

# ============= ACTUATOR =============
management.endpoints. web.exposure.include=health,mappings,info
```

---

## 📋 Próximas Features

- [ ] Autenticação com JWT
- [ ] Documentação Swagger/OpenAPI
- [ ] Testes automatizados (JUnit + Mockito)
- [ ] Validações customizadas
- [ ] Paginação de resultados
- [ ] Tratamento global de exceções

---

## 👨‍💻 Autor

**Andreoly Jesus**

- 🔗 LinkedIn: [https://www.linkedin.com/in/andreoly-jesus-615571191](https://www.linkedin.com/in/andreoly-jesus-615571191)
- 📧 Email: andreolyjesus@gmail.com
- 🐙 GitHub: [@AndreolyJesus](https://github.com/AndreolyJesus)

---

## 📝 Licença

Este projeto é de código aberto sob a licença MIT.

---

**Desenvolvido com ❤️ usando Spring Boot**
