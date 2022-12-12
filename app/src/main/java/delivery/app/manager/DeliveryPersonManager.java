package delivery.app.manager;

import java.util.ArrayList;
import java.util.List;

import delivery.app.delivery.DeliveryPerson;

public class DeliveryPersonManager {
    private static List<DeliveryPerson> deliveryPersons;

    private DeliveryPersonManager() {
        
    }
    private static void populateDeliveryPersonsList(){
        if(deliveryPersons == null){

            deliveryPersons = new ArrayList<>();
            
            // Populate the list with some initial delivery persons.
            deliveryPersons.add(new DeliveryPerson("Camilo", "BICYCLE"));
            deliveryPersons.add(new DeliveryPerson("Jane", "MOTORCYCLE"));
            deliveryPersons.add(new DeliveryPerson("Bob", "BICYCLE"));
            deliveryPersons.add(new DeliveryPerson("Alice", "MOTORCYCLE"));
            deliveryPersons.add(new DeliveryPerson("Tom", "BICYCLE"));
        }
    }

    public static  DeliveryPerson findAvailableDeliveryPerson(String modeOfTransportation) {
        populateDeliveryPersonsList();
        for (DeliveryPerson deliveryPerson : deliveryPersons) {
            if (deliveryPerson.isAvailable() && deliveryPerson.getModeOfTransportation().equals(modeOfTransportation)) {
                return deliveryPerson;
            }
        }
        
        // If no delivery person is found, return null.
        return null;
    }
}
