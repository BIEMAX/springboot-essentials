package academy.springboot.controller;

import academy.springboot.request.TemplateRequest;
import academy.springboot.response.TemplateResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
