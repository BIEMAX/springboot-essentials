# Building a service with Controller, domain class, request, response and interface

To understand exactly which package does, you need to understand the order of the packages 
(it's the order that I learned to create).

1. Create a *request* with parameters
2. Create the *response* of request
3. Create the *service* (with logic of the endpoint)
4. Create the *controller* to call service
5. Create the *controller interface* with swagger documentation

Following, we will have some examples and how to create the classes.

## **1. Creating the 'request' class:**

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

## **2. Creating the 'response' class:**

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

Or:

**Example 2:**

```java

@Data
@Builder
public record TemplateResponse(String name, String middleName, String lastName) {
    
}
```

This endpoint will return (based on the example above) something like this:

```json
{
  "name": "Some name",
  "middleName": "Some middle name",
  "lastName": "Some last name"
}
```

## **3.  Creating the 'service' class:**

The 'service' class will have all the logic from the endpoint (like connect in database,
call microservices, do some math operations, like others things).

The following example return an array of *'TemplateClass'* object.

```java
import academy.springboot.request.TemplateRequest;
import academy.springboot.response.TemplateResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {

    public TemplateResponse yourMethodNameHere(TemplateRequest templateRequest) {
        return (TemplateResponse) List.of(
                new TemplateClass("Julio", "Cocielo", "Santos"),
                new TemplateClass("Roberta", "Santos", "Junior"),
                new TemplateClass("Sergio", "Ramos", "Garcia")
        );
    }

}
```

> **Note:** '@Slf4j' it's for console logs.

This class we'll write our services and order them like 'swagger tag', in other
words, each service will correspond to a TAG.

## **4. Creating the 'controller' class**

The 'controller' is the class that will call the 'service' (that will have all the logic).

In this case, the controller have a function called *getTemplateClass* that returns a
*TemplateResponse* object and receive in parameters, a *TemplateRequest* object.

```java
@Slf4j
@RestController
@RequiredArgsConstructor
public class TemplateController implements TemplateControllerApi {
    
    private final TemplateService templateService;
    
    @Override
    public TemplateResponse getTemplateClass(TemplateRequest templateRequest) {
        return templateService.yourMethodNameHere(templateRequest);
    }
}
```

## **5. Creating the 'controller' interface**

The 'controller' in the interface will contain the swagger documentation (only)
and will be implemented on controller with annotation '@Override' to replace logical
method.

The method name need to be the same in the controller, or not will work.

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