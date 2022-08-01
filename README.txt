Check commands:

curl http://localhost:5050/api/family

curl -X POST http://localhost:5050/api/family -H 'Content-Type: application/json' -d '{"name":"Yuliia","age":32}'

curl -X POST http://localhost:5050/api/family -H 'Content-Type: application/json' -d '{"name":"Alex","age":34}'

curl -X POST http://localhost:5050/api/family/json -H 'Content-Type: application/json' -d '{"name":"Pavlo","age":7}'

curl http://localhost:5050/api/family/age?name=Yuliia

curl http://localhost:5050/api/family/name?age=32

curl -X DELETE http://localhost:5050/api/family/4

curl -X PUT http://localhost:5050/api/family/1?age=32 -H 'Content-Type: application/json'