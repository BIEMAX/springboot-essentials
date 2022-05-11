package academy.springboot.controller;

import academy.springboot.request.TemplateRequest;
import academy.springboot.response.TemplateResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@Tag(name = "Template tag", description = "Template to use as template")
@RestController
@RequestMapping("/v1/template") //Path of this controller
public interface TemplateControllerApi {

    @Operation(summary = "Template summary/intro", description = "Performs the registration of a new pix key for the client.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Key created successfully.",
                    content = @Content(
                            mediaType = "application/json", schema = @Schema(
                            type = "SampleHttpResponseDto",
                            example = "{\"status\":\"OK\",\"message\":\"sample OK answer\"}")
                    )
            ),
            @ApiResponse(responseCode = "401", description = "Invalid access token."),
            @ApiResponse(responseCode = "404", description = "Customer not found."),
            @ApiResponse(responseCode = "503", description = "Unavailable service.")
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    TemplateResponse getTemplateClass(@Valid @RequestBody TemplateRequest templateRequest);
}