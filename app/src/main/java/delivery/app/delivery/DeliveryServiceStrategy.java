package delivery.app.delivery;


public interface DeliveryServiceStrategy {
    public void deliver();
    public double calculateDeliveryCost();
    public double calculateDeliveryTime();
}
