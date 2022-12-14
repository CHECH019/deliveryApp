package delivery.app.distanceDeliveryService;

public class DeliveryDistanceCalculator {

    private static int BASE_LOCATION = 100;
    
    public int calculate(int customerLocation) {
        int distance = BASE_LOCATION - customerLocation;
        return distance > 0 ? distance:-distance;
    }

}
