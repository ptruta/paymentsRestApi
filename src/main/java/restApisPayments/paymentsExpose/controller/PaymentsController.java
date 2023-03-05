package restApisPayments.paymentsExpose.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restApisPayments.paymentsExpose.exception.PaymentException;
import restApisPayments.paymentsExpose.model.Payment;
import restApisPayments.paymentsExpose.service.PaymentsService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("Payments")
public class PaymentsController {

    private final PaymentsService paymentsService;
    private final ObjectMapper objectMapper;

    public PaymentsController(PaymentsService paymentsService, ObjectMapper objectMapper) {
        this.paymentsService = paymentsService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = {"/payments-refactor"})
    public ResponseEntity<String> paymentRefactor(
            final @RequestBody List<Payment> paymentsList,
            final int amount) throws PaymentException, JsonProcessingException {

        paymentsService.changeAmountToPaymentsList(paymentsList, amount);

        return ResponseEntity.status(HttpStatus.OK).body(objectMapper
                .writeValueAsString(paymentsList));
    }
}

