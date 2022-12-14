package delivery.app.utils;

import java.util.HashMap;
import java.util.Map;

public class BonusCodes {

    private static Map<String,Double> existingCodes;

    private BonusCodes(){}

    public static Map<String,Double> get(){
        if(existingCodes == null){
            existingCodes = new HashMap<>();
            existingCodes.put("D1SC0UNT10", 10.0);
            existingCodes.put("D1SC0UNT15", 15.0);
            existingCodes.put("D1SC0UNT20", 20.0);
        }
        return existingCodes;
    }
    
}
