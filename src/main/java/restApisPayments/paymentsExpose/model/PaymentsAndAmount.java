package restApisPayments.paymentsExpose.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentsAndAmount {
    private List<Payment> paymentList;

    private int amount;
}
