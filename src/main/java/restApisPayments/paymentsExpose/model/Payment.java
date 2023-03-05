package restApisPayments.paymentsExpose.model;

public class Payment {
    private Integer id;

    private int amount;
    private String type;

    public Payment(Integer id, int amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
