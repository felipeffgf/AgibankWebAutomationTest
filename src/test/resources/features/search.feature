Feature: Busca de artigos no blog
  Scenario: Busca de artigo existente no blog
    Given que o usuário está na homepage
    When o usuário busca por "Agibank"
    Then os resultados da busca devem ser exibidos

  Scenario: Busca de artigo com caracteres especiais
    Given que o usuário está na homepage
    When o usuário busca por "!@#$"
    Then nenhum resultado deve ser exibido
