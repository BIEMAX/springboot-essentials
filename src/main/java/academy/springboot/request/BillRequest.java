package academy.springboot.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillRequest {

    @NotNull(message = "description is required")
    @ApiModelProperty(value = "Nubank, internet, etc", example = "Fatura Nubank 04/22")
    public String description;

    @NotNull(message = "dueDate is required")
    @ApiModelProperty(value = "Date limit to pay the bill", example = "20/05/2022")
    public Date dueDate;

    @NotNull(message = "value is required")
    @ApiModelProperty(value = "Value of the bill", example = "1.499,78")
    public BigDecimal value;

}
