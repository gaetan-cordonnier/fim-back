# <p align="center">Food Inventory Management</p>

## Back-End Repository

## Description:

This application allows you to manage the food stock in a household to limit waste and unnecessary expenses.

**Features:**
- Google authentication.
- Recording of food or prepared meals in a database (by scanning barcodes or using the user interface) based on several criteria: categories, weight, quantity, expiration date, storage location...
- Display and management of the stock (nutri-score of food, allergens...).
- Recording and consultation of favorite recipes.
- Organization of a weekly menu based on recorded recipes.
- Verification of the availability (or not) of ingredients necessary to prepare the recipes in the stock.
- Creation of a shopping list based on the registered menu and missing ingredients.
- Receive notifications when the expiration date of food in stock is approaching.

**Future improvements:**
- Historical consumption of food.
- Proposal of menus based on a specific diet.
- Proposal of recipes based on the seasonality.

## Tech Stack:

- [Java 17](https://www.java.com/)
- [Spring-Boot v2.7.8](https://spring.io/)
  - JPA / Hibernate
  - Lombok
  - Devtools
  - Starter Web
- [Maven](https://maven.apache.org/)
- [MySQL DataBase](https://www.mysql.com/fr/)

## Installation:

1. Replace the filename /fim-back/src/main/resources/'template.application.properties' with 'application.properties'.
2. Replace the correct <'VALUES'> in the application.properties file.
   *If you don't use a MySQL database, replace the MySQL Driver in the POM.xml file with your correct database driver JPA-compatible.

```xml
<dependency>
	<groupId>com.mysql</groupId>
	<artifactId>mysql-connector-j</artifactId>
	<scope>runtime</scope>
</dependency>
```
and update the application.properties file:

```xml
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect 
```

4. Install Java 17 or more. [Documentation](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
3. Install Maven on your computer. [Documentation](https://maven.apache.org/install.html)


## Starting:
run the application with the Maven command line:
```bash
mvn spring-boot: run
```
*Enjoy!*

## Author:
#### Gaëtan Cordonnier
- Github: [gaetan-cordonnier](https://github.com/gaetan-cordonnier)
## Contact:
- Linkedin: [gaetancordonnier](https://www.linkedin.com/in/gaetancordonnier/)</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
  </dependency>
```
and update the application.properties file:

```xml
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect 
```

4. Install Java 17 or more. [Documentation](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
3. Install Maven on your computer. [Documentation](https://maven.apache.org/install.html)


## Starting:
run the application with the Maven command line:
```bash
mvn spring-boot: run
```
*Enjoy!*

## Author:
#### Gaëtan Cordonnier
- Github: [gaetan-cordonnier](https://github.com/gaetan-cordonnier)
- Linkedin: [gaetancordonnier](https://www.linkedin.com/in/gaetancordonnier/)