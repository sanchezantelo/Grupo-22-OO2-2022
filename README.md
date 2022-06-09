# Trabajo Practico Cuatrimestral Orientacion a Objetos 2 - Grupo 22

## Configuracion del entorno

- Descargar maven: https://maven.apache.org/download.cgi

- Verificar instalacion:

    PS C:\Users\> mvn -v
    
    Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
    
    Maven home:  C:\Program Files\apache-maven-3.8.5\bin\..
    
    Java version: 1.8.0_202, vendor: Oracle Corporation,  runtime: C:\Program Files\Java\jdk1.8.0_202\jre
    
    Default locale: es_AR, platform encoding: Cp1252
    
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

- Agregar plugin Spring Tools 4 del marketplace del eclipse

## Generar build 

    mvn clean install
    
## Correr webservices  

    java -jar .\target\app-v0.1.war


## Importar datos  

    grupo-22-bdd-oo2-2022.sql

## Ingresar al login desde el navegador con el usuario admin/admin o auditor/auditor  

    http://localhost:8080


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-security)
* [Bootstrap 4](https://getbootstrap.com/docs/4.6/getting-started/introduction/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
