## Error: *Consider defining a bean of type 'package' in your configuration.*

Just add the following maven context above the class:
```java
@Service
@Repository
public class ApplicationConfig {
}
```

## Error: *Consider defining a bean of type 'your.package.your.class' in your configuration.*

When you try to do some action in mongodb, the variable with annotation 
'repository' is always null.

To solve, just add the following annotation inside 'ApplicationStart' class.

```java
@EnableMongoRepositories("academy.springboot.repository")
```

## Error: *Exception authenticating MongoCredential{mechanism=SCRAM-SHA-1, userName='admin', source='admin', password=<hidden>, mechanismProperties=<hidden>}; nested exception is com.mongodb.MongoSecurityException*

Add the following code inside the 'application.properties':

```lombok.config
spring.data.mongodb.authentication-database=admin
```