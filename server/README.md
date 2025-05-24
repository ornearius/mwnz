Implementation of a simple interface server to retrieve company information

Steps

&#9745; Create default project with spec based code generation
```shell
❯ curl http://localhost:8080/companies/2
{"timestamp":"2025-05-24T04:11:37.742+00:00","status":404,"error":"Not Found","path":"/companies/2"}
```

&#9745; Wire in custom controller to implement the generated interface
```shell
❯ curl -H "Accept: application/json" http://localhost:8080/companies/1 -v
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /companies/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: application/json
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Length: 0
< Date: Sat, 24 May 2025 05:22:18 GMT
< 
```

&#9745; Implement hardcoded response
```shell
❯ curl -H "Accept: application/json" http://localhost:8080/companies/1 -v
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /companies/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: application/json
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 24 May 2025 05:36:26 GMT
< 
* Connection #0 to host localhost left intact
{"id":1,"name":null,"description":null}
```
&#9745; Implement service response
```shell
❯ curl -H "Accept: application/json" http://localhost:8080/companies/2 
{"id":2,"name":"test","description":"123"}
```

