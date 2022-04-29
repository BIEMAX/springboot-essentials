package academy.springboot.controller;

import academy.springboot.domain.BillToPay;
import academy.springboot.request.BillRequest;
import academy.springboot.response.BillResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Bill") //Swagger tag
@RequestMapping("/v1/bill") //Path of this controller
public interface BillsControllerApi {

    @ApiOperation(value = "Performs the registration of a new pix key for the client.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Bill created successfully."),
            @ApiResponse(code = 401, message = "Invalid access token."),
            @ApiResponse(code = 404, message = "Customer not found."),
            @ApiResponse(code = 503, message = "Unavailable service.")
    })
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    BillResponse createNewBill(@Valid @RequestBody BillRequest billRequest);

    @ApiOperation(value = "Performs the registration of a new pix key for the client.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Get bill list successfully."),
            @ApiResponse(code = 401, message = "Invalid access token."),
            @ApiResponse(code = 404, message = "Customer not found."),
            @ApiResponse(code = 503, message = "Unavailable service.")
    })
    @GetMapping("/{month}/{year}/{description}")
    @ResponseStatus(HttpStatus.OK)
    List<BillToPay> getBillsList(@RequestParam("month") Optional<Integer> month,
                                 @RequestParam("year") Optional<Integer> year,
                                 @RequestParam("description") Optional<String> description
                                 );

}
