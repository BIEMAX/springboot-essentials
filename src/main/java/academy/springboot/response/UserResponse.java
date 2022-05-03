package academy.springboot.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    public final String user;
    public final String password;
    public final String email;
    public final Boolean loggedIn;
    public final Boolean active;
}
