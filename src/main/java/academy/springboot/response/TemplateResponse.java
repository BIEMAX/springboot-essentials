package academy.springboot.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemplateResponse {

    private final String name;
    private final String middleName;
    private final String lastName;
}
