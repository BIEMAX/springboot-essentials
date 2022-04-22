package academy.springboot.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRequest {

    @NotNull(message = "name is required")
    @ApiModelProperty(value = "Name of the user", example = "Joao")
    private String name;

    @ApiModelProperty(value = "Middle name of the user", example = "Beilke")
    private String middleName;

    @ApiModelProperty(value = "Last name of the user", example = "Santos")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime requestDateTime;
}