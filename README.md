# Introduction

Project to start learning springboot for java, that consists in in:

-develop micro services

-connect in SQL and NoSQL databases

-create automated tests

# Requirements

1. JDK 11
2. Maven 3
3. Lombok

# About Maven

# About Lombok

Lombok is a framework for Java that allows you to write code eliminating "verbosity" (getters and setters), which allows you to save development time for what is really important. Its use allows generating, at compile time, getters and setters, constructor methods, builder pattern and much more.

Bellow we've an example how we usually build a class in java without lombok: 

```java
public class Person {

    private String name;
    
    public void getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Person() { }
}
```

Bellow we've an example how we build a class using lombok:

```java
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person{
    private String name;
}
```

# Running in localhost

To execute in localhost, run in terminal:
```bash
mvn spring-boot:run
```

