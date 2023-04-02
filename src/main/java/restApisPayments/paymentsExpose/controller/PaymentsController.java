package restApisPayments.paymentsExpose.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restApisPayments.paymentsExpose.exception.PaymentException;
import restApisPayments.paymentsExpose.model.PaymentsAndAmount;
import restApisPayments.paymentsExpose.service.PaymentsService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("Payments")
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentsService paymentsService;
    private final ObjectMapper objectMapper;

    @PostMapping(value = {"/payments-refactor"},
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> paymentRefactor(
            final @RequestBody PaymentsAndAmount paymentsAndAmount) throws PaymentException, JsonProcessingException {

        paymentsService.changeAmountToPaymentsList(paymentsAndAmount.getPaymentList(),
                paymentsAndAmount.getAmount());

        return ResponseEntity.status(HttpStatus.OK).body(objectMapper
                .writeValueAsString(paymentsAndAmount.getPaymentList()));
    }

    @PostMapping(value = {"/payments-refactor-again"},
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> paymentRefactorAgain(
            final @RequestBody PaymentsAndAmount paymentsAndAmount) throws PaymentException, JsonProcessingException {

        paymentsService.changeAmountToPaymentsListAgain(paymentsAndAmount.getPaymentList(),
                paymentsAndAmount.getAmount());

        return ResponseEntity.status(HttpStatus.OK).body(objectMapper
                .writeValueAsString(paymentsAndAmount.getPaymentList()));
    }

    @PostMapping(value = {"/payments-refactor-scheduled"},
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> paymentRefactorScheduled() throws PaymentException, JsonProcessingException {

        paymentsService.changeAmountToPaymentsListScheduled();

        return ResponseEntity.status(HttpStatus.OK).body(objectMapper
                .writeValueAsString("Working"));
    }

    @PostMapping(value = {"/payments-refactor-again-scheduled"},
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> paymentRefactorAgainScheduled() throws PaymentException, JsonProcessingException {

        paymentsService.changeAmountToPaymentsListAgainScheduled();

        return ResponseEntity.status(HttpStatus.OK).body(objectMapper
                .writeValueAsString("Working"));
    }
}

