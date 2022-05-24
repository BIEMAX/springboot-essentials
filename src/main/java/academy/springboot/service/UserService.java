package academy.springboot.service;

import academy.springboot.domain.User;
import academy.springboot.exception.UserInactiveException;
import academy.springboot.exception.UserNotFound;
import academy.springboot.repository.UserRepository;
import academy.springboot.request.UserLoginRequest;
import academy.springboot.request.UserRequest;
import academy.springboot.response.UserResponse;
import academy.springboot.utils.Cryptography;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Cryptography cryptography;

    public UserResponse createUser(UserRequest userRequest) {
        try {
            String passCrypto = cryptography.Encrypt(userRequest.getPassword());
            User user =
                    User.builder()
                            .user(userRequest.getUser())
                            .password(passCrypto)
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
            log.warn(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    public UserResponse getUser(UserLoginRequest userLoginRequest) {
        try {
            String passEncrypt = cryptography.Encrypt(userLoginRequest.getPassword());
            List<User> loggedUser = userRepository.findByUserAndPassword(userLoginRequest.getUser(), passEncrypt);
            if (loggedUser.isEmpty()) throw new UserNotFound();
            else if (!loggedUser.get(0).active) throw new UserInactiveException();
            else {
                return UserResponse.builder()
                        .message("Successful to get the user")
                        .information("Success")
                        .active(Boolean.TRUE)
                        .loggedIn(Boolean.FALSE)
                        .build();
            }
        }
        catch (Exception ex) {
            log.warn(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}