# Usual Errors

Solve the error:

*Consider defining a bean of type 'package' in your configuration.*

Just add the following maven context above the class:
```java
@Service
@Repository
public class ApplicationConfig {
}
```


# Building a service with Controller, domain class, request, response and interface

To understand exactly which package does, you need to understand the order of the packages 
(its the order that I learned to create).

- a
- B
- c

1. Request Package

The 'request' package contains the parameters (mandatory or not),
contains some example too.

2. Response Package

The 'response' package contains an object (with the parameters) that will return in case 
of success case. 
