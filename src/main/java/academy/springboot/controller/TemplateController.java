package academy.springboot.controller;

import academy.springboot.domain.TemplateClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Api(tags = "Template tag") //Swagger tag
@RestController
@RequestMapping("/v1/template") //Path of this controller
public class TemplateController {

    @ApiOperation("Get a list of names")
    @GetMapping(path = "list") //subpath
    @ResponseStatus(HttpStatus.OK)
    public List<TemplateClass> list() {
        return List.of(new TemplateClass("Julio"),
                        new TemplateClass("Roberta"),
                        new TemplateClass("Sergio"));
    }
}
