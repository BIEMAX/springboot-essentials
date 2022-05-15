package academy.springboot.config;

import lombok.Getter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Getter
@AllArgsConstructor
public class ApplicationConfig {

    @Value("${server.port}")
    private final String applicationPort;

    @Value("${api-secret-key}")
    private final String secretKey;

}