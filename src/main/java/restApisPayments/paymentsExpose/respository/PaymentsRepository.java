package restApisPayments.paymentsExpose.respository;

import org.springframework.stereotype.Repository;
import restApisPayments.paymentsExpose.model.Payment;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentsRepository {
    public List<Payment> changeTheAmountOfListOfPayments(List<Payment> paymentList, int amount) {
        List<Payment> payments = new ArrayList<>();
        for (Payment payment : paymentList) {
            payment.setAmount(amount);
            payments.add(payment);
        }
        return payments;
    }
}
