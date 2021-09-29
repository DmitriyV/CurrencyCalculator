# Currency Calculator

Requirements:
JDK: 11.0.11
sbt: 1.5.5
Scala: 3.0.2


Endpoints

POST http://localhost:8080/api/eur/from

Request payload in JSON

{
  "to": "USD",
  "value": 3846.15
}

Response in JSON
{
  "from": "EUR",
  "to": "USD",
  "value": 3846.15,
  "result": 4489.18
}

POST http://localhost:8080/api/eur/to

Request payload in JSON

{
  "from": "USD",
  "value": 3846.15
}

Response in JSON
{
  "from": "USD",
  "to": "EUR",
  "value": 4489.18,
  "result": 3846.15
}

GET http://localhost:8080/api/currency/all
