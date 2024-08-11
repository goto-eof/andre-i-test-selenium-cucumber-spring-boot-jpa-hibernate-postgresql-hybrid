# POC: Cucumber + Selenium + TestNG + Spring Boot + Spring JPA + Hibernate + Postgresql (single-thread + multi-thread)

POC implemented with the latest versions of Cucumber + Selenium + TestNG + Spring Boot + Spring JPA + Hibernate +
JDK (21) - single-thread + multi-thread. It allows to make automated tests for a web application (in this case the
target is my portfolio https://andre-i.eu). See also
the [single-thread](https://github.com/goto-eof/andre-i-test-selenium-cucumber-spring-boot-single-thread)
and [multi-thread](https://github.com/goto-eof/andre-i-test-selenium-cucumber-spring-boot-multi-thread) versions.

# It will not work XD

This application requires a table, called el_tag, for which i did not commited the DDL (I need more time). But on my
notebook it works
fine :P 
The project configuration is fine, trust me B)

# Configuration

Edit `config.properties` by choosing your OS and browser:

```
# can be linux or windows
com.andreidodu.test.os=linux

# can be firefox or chrome
com.andreidodu.test.browser=chrome
```

# Run tests

Run the following command from the root of the project:

 ```
  ./gradlew clean test
 ```

# Moreover

- this application was developed on Linux and tested on Linux Ubuntu 24.04 LTS (and should work also on Windows 11)
- for Linux users: in case of browser issues, make sure that firefox or chrome were not installed from snap (but with
  apt-get install)
