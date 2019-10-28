# language: pt
# author: XXXX
# version: 1.0
# encoding: UTF-8
Funcionalidade: Cadastrar Cliente

  Contexto: Evidenciar Teste;
    Dado que estou na página de login através da url "urlLogin"
    E preencho os campos para logar
      | admin | admin |
    E clico no botão Signin
    
    E que utilizo o word para evidências com as informações de execução
      | Homologação | Cadastrar clientes na aplicação da XXXX | Cadastrar clientes na aplicação da XXXX | Cadastrar clientes na aplicação da XXXX com sucesso | Cadastrar clientes na aplicação da XXXX com sucesso | NOME SOBRENOME | 01 | 01 |

  @execute @chrome-same-session @closeBrowser
  Esquema do Cenario: CT - CADASTRAR CLIENTES - Incluir clientes com Sucesso.

    Quando clico no menu QA > Clientes
    E seleciono a opção Incluir
    E preencho o campo nome <NOME> cpf <CPF> status <ATIVO> saldo <SALDO>
    E clico no botão salvar
    Então a aplicação exibe a mensagem <MENSAGEM>
   

    Exemplos:
      | NOME        | CPF         | ATIVO	    | SALDO | MENSAGEM                    |
      | "aleatório" | 29277989823 | "Ativo"	  | 50000 | "Cliente salvo com sucesso" |
      
      