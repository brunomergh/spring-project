# Spring-boot-mysql
Projeto web service utilizando spring boot.

Endpoints disponíveis:

POST http://localhost:8080/conta/ [ { "cpf": 12345678912, "nome": "Bruno Dell Orto Mergh", "saldo": 100 }, { "cpf": 78945612336, "nome": "Joao Bezerra", "saldo": 150 } ]

GET http://localhost:8080/conta/getContas

GET http://localhost:8080/conta/12345678912

PUT http://localhost:8080/conta/update { "cpf": 12345678912, "nome": "Bruno DellOrto Mergh", "saldo": 120 }

DELETE http://localhost:8080/conta/ { "cpf": 12345678912 }

PUT http://localhost:8080/conta/transferenciaEntreContas { "cpfOrigem": 78945612336, "valorTransferencia": 10, "cpfDestino": 12345678912 }

PUT http://localhost:8080/conta/deposito { "valorTransferencia": 30, "cpfDestino": 12345678912 }

PUT http://localhost:8080/conta/saque { "valorTransferencia": 10, "cpfDestino": 12345678912 }
