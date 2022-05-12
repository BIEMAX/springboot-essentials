package academy.springboot.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    public final String message;
    public final String information;
    public final Boolean loggedIn;
    public final Boolean active;
}
