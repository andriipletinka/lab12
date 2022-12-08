package chainofresponsibility;

import lombok.Setter;

public abstract class Handler {
    private final int quantity;
    @Setter
    public Handler next;

    public Handler(int quantity) {
        this.quantity = quantity;
    }
    public void process(int amount) {
        if (amount % quantity > 0 && next == null) {
            throw new IllegalArgumentException();
        } else if (next != null && amount % quantity != 0) {
            System.out.println(amount / quantity + " * " + quantity);
            next.process(amount % quantity);
        } else {
            System.out.println(amount / quantity + " * " + quantity);
        }
    }
}
