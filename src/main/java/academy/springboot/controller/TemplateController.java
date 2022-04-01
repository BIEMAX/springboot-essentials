package academy.springboot.controller;

import academy.springboot.domain.TemplateClass;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(tags = "Template tag") //Swagger tag
@RequestMapping("/v1/template") //Path of this controller
public class TemplateController {

    @GetMapping(path = "list") //sub-path
    @ResponseStatus(HttpStatus.OK)
    public List<TemplateClass> list() {
        return List.of(new TemplateClass("Julio"),
                        new TemplateClass("Roberta"),
                        new TemplateClass("Sergio"));
    }
}
