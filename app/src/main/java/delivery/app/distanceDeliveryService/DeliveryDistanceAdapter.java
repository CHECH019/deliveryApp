package delivery.app.distanceDeliveryService;

public class DeliveryDistanceAdapter implements DeliveryDistanceAPI {
    private DeliveryDistanceCalculator distanceCalculator;



    public DeliveryDistanceAdapter(DeliveryDistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }


    @Override
    public double calculateDeliveryDistance(String address) {
        int d = Integer.parseInt(address.split(" ")[1]);
        return distanceCalculator.calculate(d);
    }
    
}
