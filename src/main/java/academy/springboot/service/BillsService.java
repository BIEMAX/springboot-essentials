package academy.springboot.service;

import academy.springboot.domain.BillToPay;
import academy.springboot.repository.BillToPayRepository;
import academy.springboot.request.BillRequest;
import academy.springboot.response.BillResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class BillsService {

    @Autowired
    private BillToPayRepository billsRepository;

    public BillResponse createNewBill(BillRequest billRequest) {
        log.info("Start creation from a new bill's to pay");

        BillToPay bill =
                BillToPay.builder()
                .description(billRequest.getDescription())
                .dueDate(billRequest.getDueDate())
                .value(billRequest.getValue())
                        .build();

        try {
            billsRepository.save(bill);

            log.info("Billed created");

            return BillResponse.builder()
                    .message("Successful to save the bill")
                    .information("Success")
                    .build();
        }
        catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

//    public BillResponse getBills(BillRequest billRequest) {
//        log.info("Start querying bill's to pay");
//        return null;
//    }
}