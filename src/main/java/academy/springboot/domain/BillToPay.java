package academy.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class that represents a unique bill inside 'Bills' collection in Mongodb.
 */
@Builder
@Getter
@Document(collection = "Bills")
public class BillToPay {

    @MongoId
    private String id;
    private String description;
    private Date dueDate;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal value;
}