package delivery.app.utils;

import java.util.HashMap;
import java.util.Map;

public class SystemVariablesManager {
    private static SystemVariablesManager systemVariables;
    private Map<String,Double> existingCodes = new HashMap<>();
    private double priorityOrderFee;
    private double lowPriotityDiscount;
    private double bicyleDeliveryCostKm;
    private double motorcyleDeliveryCostKm;
    private double bicyleDeliveryVelocity;
    private double motorcyleDeliveryVelocity;

    

    private SystemVariablesManager() {
    }

    public static SystemVariablesManager getInstance(){
        if(systemVariables == null){
            systemVariables = new SystemVariablesManager();
        }
        return systemVariables;
    }

    public void addCoupon(String cupon, double descuento){
        existingCodes.put(cupon, descuento);
    }
    public double getCouponDiscount(String cupon){
        return existingCodes.get(cupon);
    }
    public void removeCouponDiscount(String cupon){
        existingCodes.remove(cupon);
    }
    public boolean existCoupon(String cupon){
        return existingCodes.containsKey(cupon);
    }
    public double getMotorcyleDeliveryVelocity() {
        return motorcyleDeliveryVelocity;
    }

    public void setMotorcyleDeliveryVelocity(double motorcyleDeliveryVelocity) {
        this.motorcyleDeliveryVelocity = motorcyleDeliveryVelocity;
    }

    public double getBicyleDeliveryVelocity() {
        return bicyleDeliveryVelocity;
    }

    public void setBicyleDeliveryVelocity(double bicyleDeliveryVelocity) {
        this.bicyleDeliveryVelocity = bicyleDeliveryVelocity;
    }

    public double getMotorcyleDeliveryCostKm() {
        return motorcyleDeliveryCostKm;
    }

    public void setMotorcyleDeliveryCostKm(double motorcyleDeliveryCostKm) {
        this.motorcyleDeliveryCostKm = motorcyleDeliveryCostKm;
    }

    public double getBicyleDeliveryCostKm() {
        return bicyleDeliveryCostKm;
    }

    public void setBicyleDeliveryCostKm(double bicyleDeliveryCostKm) {
        this.bicyleDeliveryCostKm = bicyleDeliveryCostKm;
    }

    public double getLowPriotityDiscount() {
        return lowPriotityDiscount;
    }

    public void setLowPriotityDiscount(double lowPriotityDiscount) {
        this.lowPriotityDiscount = lowPriotityDiscount;
    }

    public double getPriorityOrderFee() {
        return priorityOrderFee;
    }

    public void setPriorityOrderFee(double priorityOrderFee) {
        this.priorityOrderFee = priorityOrderFee;
    }

    public Map<String, Double> getExistingCodes() {
        return existingCodes;
    }

    public void setExistingCodes(Map<String, Double> existingCodes) {
        this.existingCodes = existingCodes;
    }
}
