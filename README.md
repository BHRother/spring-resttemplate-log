# Spring Boot + Rest Template full logging

This example shows how to log all the requests/responses from a RestTempalte call.

## About the example

* Spring Boot 1.5.6.RELEASE
* Spring Web 4.3.10.RELEASE
* Slf4j 1.7.25
* Logback 1.1.11
* Groovy 2.4.12

The interceptor FullLoggingInterceptor is the responsible to print all the requests made through restTemplate.

For this, we need to specify the interceptor for this object declaring in a @Configuration class, in this example: ApplicationConfiguration

```

@Configuration
class ApplicationConfiguration {

  @Autowired
  FullLoggingInterceptor fullLoggingInterceptor

  @Bean
  RestTemplate restTemplate(){
    RestTemplate restTemplate = new RestTemplate()
    restTemplate.interceptors = [fullLoggingInterceptor]
    restTemplate
  }
}

```


### How to build the example

```
 ./gradlew clean build
```

### How to Run
```
 ./gradlew bootRun
```

Call the endpoint:

```
http://localhost:8080/spring-resttemplate-log/
```

Then check in the logs the result:
```
INFO  com.github.bhrother.Application - Started Application in 3.694 seconds (JVM running for 6.383) 
INFO  o.a.c.c.C.[.[.[/spring-resttemplate-log] - Initializing Spring FrameworkServlet 'dispatcherServlet' 
INFO  o.s.web.servlet.DispatcherServlet - FrameworkServlet 'dispatcherServlet': initialization started 
INFO  o.s.web.servlet.DispatcherServlet - FrameworkServlet 'dispatcherServlet': initialization completed in 20 ms 
DEBUG c.g.b.i.FullLoggingInterceptor - ===========================request begin================================================ 
DEBUG c.g.b.i.FullLoggingInterceptor - URI         : http://localhost:8080/spring-resttemplate-log/users 
DEBUG c.g.b.i.FullLoggingInterceptor - Method      : GET 
DEBUG c.g.b.i.FullLoggingInterceptor - Headers     : {Accept=[application/json, application/*+json], Content-Length=[0]} 
DEBUG c.g.b.i.FullLoggingInterceptor - Request body:  
DEBUG c.g.b.i.FullLoggingInterceptor - ===========================request end================================================ 
DEBUG c.g.b.i.FullLoggingInterceptor - ===========================response begin========================================== 
DEBUG c.g.b.i.FullLoggingInterceptor - Status code  : 200 
DEBUG c.g.b.i.FullLoggingInterceptor - Status text  : null 
DEBUG c.g.b.i.FullLoggingInterceptor - Headers      : {Content-Type=[application/json;charset=UTF-8], Transfer-Encoding=[chunked], Date=[Tue, 08 Aug 2017 15:11:33 GMT]} 
DEBUG c.g.b.i.FullLoggingInterceptor - Response body: {"firstName":"Bruno","lastName":"Rother","version":"0.0.1"} 
DEBUG c.g.b.i.FullLoggingInterceptor - ===========================response end================================================= 

```