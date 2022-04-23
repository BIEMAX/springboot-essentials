# Building a service with Controller, domain class, request, response and interface

To understand exactly which package does, you need to understand the order of the packages 
(it's the order that I learned to create).

**1.  Creating a 'service' class:**

You need create a class inside the package 'service' with the basic structure:

```java
@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {
    
}
```

> **Note:** '@Slf4j' it's for console logs.

This class we'll write our services and order them like 'swagger tag'

**2. Creating 'request' class:**

The 'request' class we will write the requested arguments and if they're mandatory
or not. Following have an example of request class:

```java
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRequest {

    @NotNull(message = "name is required")
    @ApiModelProperty(value = "Name of the user", example = "Joao")
    private String name;

    @ApiModelProperty(value = "Middle name of the user", example = "Beilke")
    private String middleName;
}
```

**3. Creating 'response' class:**

The 'response' class we will write the parameters that our endpoint will
return (array of data, object, id, etc). . Following have some examples of response class:

**Example 1:**

```java
@Data
@Builder
public class TemplateResponse {

    private final String name;
    private final String middleName;
    private final String lastName;
}
```

**Example 2:**

```java

@Data
@Builder
public record TemplateResponse(String name, String middleName, String lastName) {
    
}
```


**4. Creating the 'controller' class **

The 'controller' is the class that will have all the logic (query in database, calculations,
rules, etc).