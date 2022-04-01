package academy.springboot.controller;

import academy.springboot.domain.TemplateClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("template")
public class TemplateController {

    @GetMapping(path = "list") //localhost:8080/template/list
    public List<TemplateClass> list() {
        return List.of(new TemplateClass("Julio"),
                        new TemplateClass("Roberta"),
                        new TemplateClass("Sergio"));
    }
}
