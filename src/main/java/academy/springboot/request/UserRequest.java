package academy.springboot.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    public final String user;
    public final String password;
    public final String email;
    public final Boolean loggedIn;
    public final Boolean active;
}
