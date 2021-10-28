# Aplicação desafio proposto de gerencia de usuário.
## Pré-requisitos para execução o projeto:
* Gradle
* Java 11 (versão 11 da linguagem podendo ser do Oracle JDK ou OpenJDK)

## Como executara a aplicação:
**Tenha o Gradle instalado**
Caso esteja em ambiente Linux utilize os seguintes comandos dentro da pasta do projeto:
```
gradle build
gradle run
```

## Requisitos:
* Gerenciamento dos cargos, um cargo tem nome com opções de editar e listar os cargos.
* Gerenciamento de perfis de usuários onde nome é obrigatório e único de um usuário.
* Um usuário é composto por nome, CPF, data de nascimento, sexo, cargo, data de cadastro do usuário.
* O sistema tem que possibilitar editar os usuários.
* Deve ter uma generalização de usuário que tenha nome, CPF, data de nascimento, e sexo.


## Especificações técnicas:
Para essa implementação será utilizadas as ferramentas:
* Gradle
* OpenCSV

## Roadmap:
- [x] preparar ambiente Gradle.
- [x] definir ecossistema de ferramentas.
- [ ] implementação do controle de dados e regra de negócio.
- [ ] implementação da visão.
- [ ] implementação da persistência dos dados.
