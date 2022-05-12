package academy.springboot.controller;

import academy.springboot.config.ApplicationConfig;
import academy.springboot.request.UserRequest;
import academy.springboot.response.UserResponse;
import academy.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

    private final ApplicationConfig applicationConfig;
    private final UserService userService;

    @Override
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
