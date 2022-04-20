package academy.springboot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Repository
public class ApplicationConfig {

    @Value("${server.port}")
    private String applicationPort;

    public String getApplicationPort() {
        return applicationPort;
    }
}
