package restApisPayments.paymentsExpose.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restApisPayments.paymentsExpose.model.Payment;
import restApisPayments.paymentsExpose.respository.PaymentsRepository;

import java.util.List;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public List<Payment> changeAmountToPaymentsList(List<Payment> paymentList, int amount) {
        return paymentsRepository.changeTheAmountOfListOfPayments(paymentList, amount);
    }

}
