# language: pt
# author: xxxx
# version: 1.0
# encoding: UTF-8

Funcionalidade: Login Aplicação

  Contexto: Evidenciar Teste;
    Dado que utilizo o word para evidências com as informações de execução
      | Homologação | Logar na Aplicação da XXXX | Logar na Aplicação da XXXX | Logar na Aplicação da XXXX com sucesso | Logar na Aplicação XXXX com sucesso | NOME SOBRENOME | 01 | 01 |

  @execute @chrome-same-session @closeBrowser @generate-word
  Esquema do Cenario: CT-LOGIN - Logar na Aplicação da XXXX com sucesso.

    Dado que estou na página de login através da url "urlLogin"
    Quando preencho o campo login <LOGIN>
    E preencho o campo password <PASSWORD>
    E clico no botão Signin
    Então a aplicação exibe a mensagem <MENSAGEM> de bem vindo
    E clico no botão Sair

    Exemplos:
      | LOGIN   | PASSWORD | MENSAGEM            |
      | "admin" | "admin"  | "Bem vindo ao XXXX" |
