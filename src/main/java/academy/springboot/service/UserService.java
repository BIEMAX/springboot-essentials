package academy.springboot.service;

import academy.springboot.domain.User;
import academy.springboot.repository.UserRepository;
import academy.springboot.request.UserRequest;
import academy.springboot.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        try {
            User user =
                    User.builder()
                            .user(userRequest.getUser())
                            .password(userRequest.getPassword())
                            .email(userRequest.getEmail())
                            .loggedIn(Boolean.FALSE)
                            .active(Boolean.TRUE)
                            .build();

            userRepository.save(user);

            log.info("User created");

            return UserResponse.builder()
                    .message("Successful to create new user")
                    .information("Success")
                    .active(Boolean.TRUE)
                    .loggedIn(Boolean.FALSE)
                    .build();
        }
        catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}