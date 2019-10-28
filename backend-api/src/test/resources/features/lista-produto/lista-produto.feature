#language: pt
#Author: XXXX
#Version: 1.0
#Encoding: UTF-8
Funcionalidade: - Consulta lista de produtos da XXXX

  @TESTAPI-01
  Cenario: CT01 - consultar lista de produtos
    Dado que faco uma requisicao GET/products
    Entao devo receber um status code '200'
    E retorno dos produtos
