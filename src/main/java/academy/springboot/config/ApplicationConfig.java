package academy.springboot.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Getter
@Component
@Repository
@NoArgsConstructor
public class ApplicationConfig {

    @Value("${server.port}")
    private String applicationPort;

    @Value("${api-secret-key}")
    private String secretKey;

}