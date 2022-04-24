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

This class we'll write our services and order them like 'swagger tag', each
service will correspond to a TAG.

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


**4. Creating the 'controller' class**

The 'controller' is the class that will have all the logic (query in database, calculations,
rules, etc).

In this case, we'll just call a static methods returning static values, but could be a database 
values, arithmetic functions and other.

```java
@Slf4j
@RestController
@RequiredArgsConstructor
public class TemplateController implements TemplateControllerApi {
    
    @Override
    public TemplateResponse getTemplateClass(TemplateRequest templateRequest) {
        return TemplateResponse.builder().build();
    }
}
```

**5. Creating the 'controller' interface**

The 'controller' in the interface will contain the swagger documentation (only)
and will be implemented on controller with annotation '@Override' to replace logical
method.

The method name need to be the same in the controller (with the logic), or not will works.

```java
@RestController
@Api(tags = "Template tag") //Swagger tag
@RequestMapping("/v1/template") //Path of this controller
public interface TemplateControllerApi {
    
    @ApiOperation(value = "Performs the registration of a new pix key for the client.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Key created successfully."),
            @ApiResponse(code = 401, message = "Invalid access token."),
            @ApiResponse(code = 404, message = "Customer not found."),
            @ApiResponse(code = 503, message = "Unavailable service.")
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    TemplateResponse getTemplateClass(@Valid @RequestBody TemplateRequest templateRequest);
}
```