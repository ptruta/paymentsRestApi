package restApisPayments.paymentsExpose.exception;

public class PaymentException extends RuntimeException {

    private int code;

    public PaymentException() {
        super();
    }

    public PaymentException(String message, int code) {
        super(message);
        this.code = code;
    }
}
