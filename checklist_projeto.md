# ✅ Checklist de Melhorias – Projeto Votação (Spring Boot)

## 📌 Organização / Boas práticas
- [ ] Criar **README** com:
  - [ ] Como subir o projeto (Docker, Maven, etc.).  
  - [ ] Tecnologias usadas.  
  - [ ] Fluxo de funcionamento da votação.  
  - [ ] Decisões técnicas e justificativas.  
- [ ] Corrigir **commits semânticos** → manter no infinitivo ou particípio (`Adicionado`, `Alterado`, `Ajustado`).  
- [ ] Remover **imports não utilizados**.  
- [ ] Substituir **imports com `*`** por imports específicos.  

## 📌 Arquitetura / Design
- [ ] Criar **interfaces** para definição de contratos (ex: `VotoService`, `PautaService`).  
- [ ] Usar **DTOs** para comunicação externa (input/output), em vez de expor entidades diretamente.  
- [ ] Mover **validações** para os DTOs com annotations (`@NotBlank`, `@NotNull`, `@Pattern`).  
- [ ] Ajustar **RESTful endpoints** → evitar verbos nos paths (usar substantivos).  
- [ ] Padronizar **exceptions** → todas devem estender `RuntimeException`.  
- [ ] Criar mensagens de exceções no construtor da própria exception (ex: `PautaNaoEncontradaException`).  
- [ ] Ajustar retorno do resultado da votação → retornar **ENUM cru**, e deixar a formatação/tradução para o client.  

## 📌 API / Documentação
- [ ] Corrigir documentação do **Swagger/OpenAPI**:
  - [ ] Garantir que todos os controllers aparecem (`VotoController`, `SessaoVotacaoController`).  
  - [ ] Adicionar exemplos de request/response.  
- [ ] Tornar **path da API versionável** (`/api/v1/...`).  
- [ ] Melhorar segurança → evitar exposição direta de **erros internos** nas respostas.  

## 📌 Qualidade / Testes
- [ ] Criar **testes unitários** (JUnit + Mockito) para serviços e controllers.  
- [ ] Validar cobertura de testes para casos de sucesso e erro.  

## 📌 Banco de Dados / Infra
- [ ] Melhorar `docker-compose.yml` (se necessário) → adicionar variáveis via `.env`.  
- [ ] Documentar como rodar o banco com Docker.  
