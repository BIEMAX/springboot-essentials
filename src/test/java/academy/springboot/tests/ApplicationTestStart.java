package academy.springboot.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("academy.springboot")
public class ApplicationTestStart {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTestStart.class, args);
    }

}
