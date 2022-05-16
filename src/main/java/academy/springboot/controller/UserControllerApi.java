package academy.springboot.controller;

import academy.springboot.request.UserLoginRequest;
import academy.springboot.request.UserRequest;
import academy.springboot.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User", description = "Create, update, delete and list users")
@RestController
@RequestMapping("/v1/user") //Path of this controller
public interface UserControllerApi {
    @Operation(summary = "Create new user", description = "Performs the registration of a new user.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User created successfully.",
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
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    UserResponse createUser(@Valid @RequestBody UserRequest userRequest);


    @Operation(summary = "Get an existing user", description = "Performs the validation if an user exist.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User get successfully.",
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
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getUser(@Valid @RequestBody UserLoginRequest userLoginRequest);
}