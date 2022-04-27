package academy.springboot.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillResponse {

    public final String message;
    public final String information;

}
