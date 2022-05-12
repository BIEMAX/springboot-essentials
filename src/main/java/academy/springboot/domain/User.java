package academy.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Getter
@Document(collection = "Users")
public class User {
    @MongoId
    private String id;

    public String user;
    public String password;
    public String email;
    public Boolean loggedIn;
    public Boolean active;
}
