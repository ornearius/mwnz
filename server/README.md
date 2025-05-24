# Implementation of a simple interface server to retrieve company information

### Requirements: 
Java 21

### Operation:
- git clone git@github.com:ornearius/mwnz.git
- ./mvnw clean install
- ./mvnw spring-boot:run

The service should now be available on http://localhost:8080/companies/{id}

### Notes from a development journey

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
&#9746; Create CI build on branch pushes

&#9746; Create Dockerfile for container operations

&#9746; Build test environment and CD stages

&#9746; Create environment specific properties

&#9746; Setup https certs etc.

&#9746; Wire in Spring Security, ideally with OAuth2 otherwise with a hardcoded basic auth.

Note that at this point partners can start integration work.

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

&#9745; Add service to retrieve remote data
```shell
❯ curl -H "Accept: application/json" http://localhost:8080/companies/1 
{"id":1,"name":"MWNZ","description":"..is awesome"}

❯ curl -H "Accept: application/json" http://localhost:8080/companies/2
{"id":2,"name":"Other","description":"....is not"}

❯ curl -H "Accept: application/json" http://localhost:8080/companies/3 -v
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /companies/3 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: application/json
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 404 
< Content-Length: 0
< Date: Sat, 24 May 2025 08:40:21 GMT
< 

```
&#9746; Handle 404 gracefully most likely using the same response hacking used in the default implementation.

Redo remote service using http exchange. Much nicer and easier to understand.

Fix the http message handlers to cope with the XML coming with text/plain header rather than the expected application/xml one.

I did note that updating the url in the openapi-companies.yaml does generate the correct response but it is not handled by the page.