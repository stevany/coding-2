#CODING-2

1. Create database name coding
2. running apps (table automatically created)
3. running sql script to insert seeder village.

api for electricity counter:
```
/POST 
{{host}}/api/counter_callback
```

```
{"counterId": 1,"amount": 1000}
```
api for consumption report:
```
/GET
{{host}}/api/consumption_report?duration=24h
```
