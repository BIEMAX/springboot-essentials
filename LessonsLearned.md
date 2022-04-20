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