package academy.springboot.controller;

import academy.springboot.config.ApplicationConfig;
import academy.springboot.domain.TemplateClass;
import academy.springboot.request.TemplateRequest;
import academy.springboot.response.TemplateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TemplateController implements TemplateControllerApi {

    private final ApplicationConfig applicationConfig;

    @Override
    public TemplateResponse getTemplateClass(TemplateRequest templateRequest) {
        return TemplateResponse.builder().build();
    }

    @GetMapping(path = "list") //sub-path
    @ResponseStatus(HttpStatus.OK)
    public List<TemplateClass> list() {
        return List.of(new TemplateClass("Julio", "Cocielo", "Santos"),
                        new TemplateClass("Roberta", "Santos", "Junior"),
                        new TemplateClass("Sergio", "Ramos", "Garcia"));
    }

    @GetMapping(path = "config")
    @ResponseStatus(HttpStatus.OK)
    public String getApplicationConfiguration() {
        return applicationConfig.getApplicationPort();
    }
}
