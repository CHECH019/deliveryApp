package delivery.app.deliveryStrategy;


public interface DeliveryServiceStrategy {
    public void deliver();
    public double calculateDeliveryCost();
    public double calculateDeliveryTime();
}
