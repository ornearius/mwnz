Implementation of a simple interface server to retrieve company information

Steps

&#9745; Create default project with spec based code generation
```bash
❯ curl http://localhost:8080/companies/2
{"timestamp":"2025-05-24T04:11:37.742+00:00","status":404,"error":"Not Found","path":"/companies/2"}
```

&#9746; Implement custom response