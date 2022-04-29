package academy.springboot.controller;

import academy.springboot.domain.BillToPay;
import academy.springboot.request.BillRequest;
import academy.springboot.response.BillResponse;
import academy.springboot.service.BillsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BillsController implements BillsControllerApi {

    private final BillsService billsService;

    @Override
    public BillResponse createNewBill(BillRequest billRequest) {
        return billsService.createNewBill(billRequest);
    }

    @Override
    public List<BillToPay> getBillsList(Optional<Integer> month, Optional<Integer> year, Optional<String> description)  { return billsService.getBillsList(month, year, description); }

}
