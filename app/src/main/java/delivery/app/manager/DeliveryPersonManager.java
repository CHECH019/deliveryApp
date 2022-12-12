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
            
            deliveryPersons.add(new DeliveryPerson("Camilo", "BICYCLE"));
            deliveryPersons.add(new DeliveryPerson("Laura", "MOTORCYCLE"));
            deliveryPersons.add(new DeliveryPerson("Daniel", "BICYCLE"));
            deliveryPersons.add(new DeliveryPerson("Andrea", "MOTORCYCLE"));
            deliveryPersons.add(new DeliveryPerson("Javier", "BICYCLE"));
        }
    }

    public static  DeliveryPerson findAvailableDeliveryPerson(String modeOfTransportation) {
        populateDeliveryPersonsList();
        for (DeliveryPerson deliveryPerson : deliveryPersons) {
            if (deliveryPerson.isAvailable() && deliveryPerson.getModeOfTransportation().equals(modeOfTransportation)) {
                return deliveryPerson;
            }
        }
        
        return null;
    }
}
