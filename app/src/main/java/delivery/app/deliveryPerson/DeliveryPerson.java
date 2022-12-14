package delivery.app.deliveryPerson;

import delivery.app.order.Order;

public class DeliveryPerson {

    private String name;
    private String modeOfTransportation;
    private boolean available;
    private Order order;

    public DeliveryPerson(String name, String modeOfTransportation) {
        this.name = name;
        this.modeOfTransportation = modeOfTransportation;
        this.available = true;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        System.out.println("Delivery Person: "+name);
        setAvailable(false);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
  
    public String getModeOfTransportation() {
      return modeOfTransportation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModeOfTransportation(String modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

}