# Executando os testes automatizados - AgibankWebAutomationTest

Este documento descreve os passos essenciais para executar os testes automatizados do repositório AgibankWebAutomationTest.

Resumo do projeto
- Linguagem e ferramentas: Java 11 e Maven.
- Dependências principais: Selenium 4, Cucumber 7 com JUnit Platform, WebDriverManager e Allure.
- Referência do pom.xml: https://github.com/felipeffgf/AgibankWebAutomationTest/blob/b1086ab132905d1a6631ad0e514f7d6cd2626204/pom.xml

Requisitos
- JDK 11 instalado e disponível no PATH. Verifique com:
```bash
java -version
```
- Maven instalado e disponível no PATH. Verifique com:
```bash
mvn -v
```
- Navegador instalado, por exemplo Google Chrome. O WebDriverManager faz o download do driver automaticamente na maioria dos casos.
- Opcional: Allure CLI instalado para gerar e visualizar relatórios Allure. Exemplos de instalação:
  - macOS com Homebrew: `brew install allure`
  - Windows com Chocolatey: `choco install allure.commandline`
  - Windows com Scoop: `scoop install allure`

Clonando o repositório
```bash
git clone https://github.com/felipeffgf/AgibankWebAutomationTest.git
cd AgibankWebAutomationTest
```

Executando os testes
- Executar todos os testes com Maven:
```bash
mvn test
```
Esse comando baixa dependências, executa os testes via JUnit Platform e usa o WebDriverManager para gerenciar drivers de navegador.
Ou apenas execute o arquivo runner:
```
TestRunner.java
```

Executando testes por tag do Cucumber
- Para rodar cenários com uma tag específica, por exemplo @smoke, execute:
```bash
mvn -Dcucumber.filter.tags="@smoke" test
```
Se a configuração do projeto usar um arquivo de propriedades diferente, verifique `src/test/resources` para ajustar o comando.

Relatórios Allure
- Os resultados do Allure geralmente são gerados na pasta `allure-results`.
- Para visualizar o relatório com o Allure CLI:
  - Abrir um servidor local com o relatório:
  ```bash
  allure serve allure-results
  ```
  - Gerar um relatório estático e abrir:
  ```bash
  allure generate allure-results -o allure-report
  allure open allure-report
  ```

Integração com CI
- Passos básicos para um pipeline de CI:
  1. Use uma imagem ou runner com JDK 11 e Maven.
  2. Execute `mvn test`.
  3. Archive a pasta `allure-results` como artefato de build.
  4. Opcionalmente, gere o relatório Allure no pipeline para publicação.

Onde verificar configurações adicionais
- Consulte `src/test/resources` para arquivos como `junit-platform.properties`, arquivos de ambiente ou outras configurações que definam:
  - localização das feature files do Cucumber,
  - pacotes de step definitions,
  - plugins e formatadores,
  - modo de execução, por exemplo headless.

Soluções para problemas comuns
- Se aparecer erro de versão do Java, confirme a saída de `java -version` e instale ou selecione o JDK 11.
- Se houver problemas com drivers de navegador, verifique a versão do navegador. O WebDriverManager costuma resolver automaticamente, mas pode ser necessário limpar o cache do WebDriverManager ou atualizar o navegador.
- Se o Allure CLI não estiver disponível, instale o Allure ou gere relatórios com outra ferramenta de sua preferência.
- Se os testes não forem encontrados, confirme se as feature files e as classes de teste estão nos caminhos esperados e se `cucumber-junit-platform-engine` está presente no pom.xml.

Boas práticas recomendadas
- Mantenha este arquivo na raiz do repositório com o nome `README.md` para que as instruções fiquem sempre acessíveis.
- Nunca comite credenciais em texto plano. Use variáveis de ambiente ou um cofre de segredos no CI.
- Para executar testes em modo sem interface gráfica no CI, configure o driver em modo headless ou use imagens com navegadores headless.
- Atualize as dependências no `pom.xml` quando necessário e registre mudanças relevantes no controle de versão.

Referências
- pom.xml com dependências e plugins: https://github.com/felipeffgf/AgibankWebAutomationTest/blob/b1086ab132905d1a6631ad0e514f7d6cd2626204/pom.xml
