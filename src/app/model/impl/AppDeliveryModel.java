package app.model.impl;

import app.entity.Purchase;
import app.model.AppModel;
import app.utils.Constants;

public class AppDeliveryModel implements AppModel {
    //final double DELIVERY_PERCENTAGE = 2.5;
    public double deliveryRate = Constants.DELIVERY_PERCENTAGE;
    @Override
    public double calcPayment(Purchase purchase) {
        double cost = purchase.getQuota() * purchase.getPrice();
        return cost + (cost/100) * deliveryRate;
    }
}
