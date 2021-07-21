# JavaSpring
# Content
- Introduction
- Excercise
- Install dependencies
- Run code
- Information

## Introduction

**What is Spring?**
> Spring is the most used Java framework. It offers us tools that allow us to create more advanced projects, with better practices and in less time. It also has a great community, which gives us a lot of documentation and help. Spring has a modular and flexible structure, which makes us use only what we need. <p/>
> We are going to use 4 Sping subprojects:
> - **Spring Framework:** Allows you to create business applications. It is transversal, since everyone uses it.
> - **Spring Boot:** With which we can create self-contained and self-configuring applications.
> - **Spring Data:** Manage and integrate databases.
> - **Spring Security:** Manage application security.

**What is Spring Initializr?**
> The oficial web site to generate a Spring Boot project [link](https://start.spring.io/).

**What is JPA?**
> Jpa is a standard Java specification for an ORM framework. It means that they are a series of rules that Java defines so that any framework that wants to interact with the Java database has to follow. <p/>
> The most popular Java frameworks for this purpose are:
> - Hibernate
> - TopLink
> - EclipseLink
> - ObjectDB

**Project structure**
1. **Domain layer** we will have domain objects that are part of the application context, we also have services and repository specifications that are interfaces that define what persistence must comply with.
2. **Web** our api controllers
3. **Persistence** It has the obligation to interact with the database.

**JPA annotations**
> JPA uses annotations to connect classes to DB tables and thus avoid doing it natively with SQL.

- **@Entity** It indicates to a java class that it is representing a table in our database.
- **@Table** It receives the name of the table to which the class is mapping.
- **@column** It is put to the attributes of the class, it is not mandatory, it is indicated only when the name of the column is different from the name of the attribute of the table.
- **@id** and **@EmbededID** It is the attribute as the primary key of the table within the class. @id is used when it is a simple primary key and @EmbededID when it is a composite primary key.
- **@GeneratedValue.** It allows to automatically generate values for the primary classes in our classes
- **@OneToMany** and **@MatyToOne** Represent relationships.

 <div>
    <img src = "https://github.com/ItzelAlonsoG/JavaSpring/blob/main/src/main/java/com/platzi/market/JavaSprint2.jpg" width= "100%">
</div>

### Excercise
This repository was maded based in a super market functions with products, clients and purchases. The implementation of the JPA annotations is involved We created tables and relationes with this annotations. 

We can :
- get tokens
- get purchases
- get products
- delete products
- update products
- save purchases.

## Install dependencies

- [Install OpenJDK 11](https://www.oracle.com/mx/java/technologies/javase-jdk11-downloads.html)
- [Install Intellij](https://www.jetbrains.com/es-es/idea/download/#section=windows) or another IDE thats supports OpenJDK 11 and contains gandler 
- [Install PostgreSQL](https://www.postgresql.org/download/)
- [Install Postman](https://www.postman.com/downloads/) in order to make requests to the API

You can find this dependencies in [maven repository](https://mvnrepository.com/) in this case is not necessary because the project have this dependencies.
- Add springfox-swagger2 2.9.2 or later
- Add springfox-swagger-ui 2.9.2 or later
- Add spring-boot-starter-security or later
- Add jjwt 0.9.1 or later

### Run code

1. Download this repository using:
 > $ git clone 
 
2.  Open Intellij ID and select the project.
3.  Search the file names **PlatziMarketApplication.java** right click and **Run**.

  <div>
    <img src = "https://github.com/ItzelAlonsoG/JavaSpring/blob/main/src/main/java/com/platzi/market/JavaSpring2.png" width= "100%">
</div>
5.  You will see this in the console and that's all your procejt it's runnig OK!
 <div>
    <img src = "https://github.com/ItzelAlonsoG/JavaSpring/blob/main/src/main/java/com/platzi/market/JavaSpring3.png" width= "100%">
</div>
 
 #### Information
 
 for more information you can see the [Java Spring course](https://platzi.com/clases/java-spring/ )
