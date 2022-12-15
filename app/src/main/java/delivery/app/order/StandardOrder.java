package delivery.app.order;


public class StandardOrder extends Order{
    
    private StandardOrder(Order order) {
        super(order);
    }

    public StandardOrder(String customerName, String customerAddress) {
        super(customerName, customerAddress);
        this.priority = "NORMAL";
    }

    @Override
    public Order clonar() {
        return new StandardOrder(this);
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

}