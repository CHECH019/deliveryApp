package delivery.app.deliveryServices;

import delivery.app.deliveryStrategy.DeliveryServiceStrategy;

public class DeliveryManager {
    private DeliveryServiceStrategy deliveryStrategy;
  
    public DeliveryManager(DeliveryServiceStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void deliver(){
        System.out.println("Delivery ETA: "+deliveryStrategy.calculateDeliveryTime()+" minutes");
        System.out.println("Delivery fee: $"+getDeliveryCost());
        deliveryStrategy.deliver();
    }

    public double getDeliveryTime(){
        return deliveryStrategy.calculateDeliveryTime();
    }

    public double getDeliveryCost(){
        return deliveryStrategy.calculateDeliveryCost();
    }

    public void trackDelivery(){

    }

    public void cancelDelivery(){
        
    }
}