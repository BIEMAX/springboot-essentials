package academy.springboot.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Api(tags = "Phone validations")
@RequestMapping("/v1/phone")
public class PhoneController {

    @PostMapping(path = "phone/")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isHomePhone(@RequestBody String phoneNumber) {
        return true;
    }
}
