package restApisPayments.paymentsExpose.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import restApisPayments.paymentsExpose.model.Payment;
import restApisPayments.paymentsExpose.respository.PaymentsRepository;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public List<Payment> changeAmountToPaymentsList(List<Payment> paymentList, int amount) {
        return paymentsRepository.changeTheAmountOfListOfPayments(paymentList, amount);
    }

    public List<Payment> changeAmountToPaymentsListAgain(List<Payment> paymentList, int amount) {
        return paymentsRepository.changeTheAmountOfListOfPayments(paymentList, amount);
    }

    @Scheduled(cron="1 42 17 * * *")
    public void changeAmountToPaymentsListScheduled() {
        log.info("face primul scheduled");
        paymentsRepository.changeTheAmountOfListOfPayments(Arrays.
                asList(new Payment(1, 2, "3")
                , new Payment(1, 2, "3")
                , new Payment(1, 2, "3")), 21);
    }

    @Scheduled(cron="1 43 17 * * *")
    public void changeAmountToPaymentsListAgainScheduled() {
        log.info("face al doilea scheduled");
        paymentsRepository.changeTheAmountOfListOfPayments(Arrays.
                asList(new Payment(1, 2, "3")
                        , new Payment(1, 2, "3")
                        , new Payment(1, 2, "3")), 21);
    }

    @Schedules({
            @Scheduled(cron = "1 42 17 * * *"),
            @Scheduled(cron = "1 43 17 * * *")
    })
    public void changeAmountToPaymentsListAgainSchedules() {
        log.info("face schedules job");
        paymentsRepository.changeTheAmountOfListOfPayments(Arrays.
                asList(new Payment(1, 2, "3")
                        , new Payment(1, 2, "3")
                        , new Payment(1, 2, "3")), 21);
    }

}
