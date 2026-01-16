 # GymTracker 🏋️


## Um projeto em Spring Boot para gerenciar treinos e exercícios.
Permite cadastrar treinos (ex.: pernas, ombro, bíceps) e associar exercícios a cada treino, com suas respectivas séries e repetições.

 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (em memória, para testes)
- Postman (para testar os endpoints)

 Estrutura do projeto

 ```bash
src/main/java/com/joana/gymtracker
 ├── controller
 │    ├── TreinoController.java
 │    └── ExercicioController.java
 ├── model
 │    ├── Treino.java
 │    └── Exercicio.java
 ├── repository
 │    ├── TreinoRepository.java
 │    └── ExercicioRepository.java
 └── GymtrackerApplication.java

```

 Configuração do banco H2
No arquivo application.properties:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console


Acesse o console em:
http://localhost:8080/h2-console
Use o JDBC URL: jdbc:h2:mem:testdb

📌 Endpoints disponíveis
🔹 Treinos
- GET /treinos → lista todos os treinos
- GET /treinos/{id} → busca treino por ID
- POST /treinos → cadastra treino com exercícios
{
  "tipo": "pernas",
  "exercicios": [
    { "nome": "Agachamento", "series": "3x12" },
    { "nome": "Leg Press", "series": "4x10" }
  ]
}
- PUT /treinos/{id} → atualiza treino e seus exercícios
- DELETE /treinos/{id} → remove treino e exercícios associados

🔹 Exercícios
- GET /exercicios → lista todos os exercícios
- GET /exercicios/{id} → busca exercício por ID
- POST /exercicios/{treinoId} → cadastra exercício vinculado a um treino
{
  "nome": "Rosca direta",
  "series": "3x12"
}
- PUT /exercicios/{id} → atualiza exercício
- DELETE /exercicios/{id} → remove exercício

🚀 Como rodar o projeto
- Clone o repositório:
git clone https://github.com/seuusuario/gymtracker.git
- Entre na pasta:
cd gymtracker
- Rode a aplicação:
mvn spring-boot:run
- Acesse os endpoints em:
http://localhost:8080



📊 Exemplo de fluxo
- Cadastrar treino com exercícios (POST /treinos).
- Listar treinos (GET /treinos).
- Atualizar treino (PUT /treinos/{id}).
- Deletar treino (DELETE /treinos/{id}).
- Manipular exercícios diretamente via /exercicios.

✨ Próximos passos
- Adicionar autenticação (Spring Security).
- Criar interface web ou app mobile para consumir a API.
- Persistir dados em banco real (PostgreSQL ou MySQL).
