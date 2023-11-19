package app.controller;

import app.entity.Buyer;
import app.entity.Purchase;
import app.model.impl.AppBaseModel;
import app.model.impl.AppDeliveryModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.view.AppView;

import java.io.IOException;

public class AppController {
    private final AppView view = new AppView();
    //private final static String CURRENCY = "USD";
    public String currency = Constants.CURRENCY;

    public void getPayment() throws IOException {
        String[] data = view.getData();
        Buyer buyer = getBuyer(data);
        Purchase purchase = getPurchase(data);
        String output;
        if (purchase.getDelivery()==0){
            AppBaseModel model = new AppBaseModel();
            String payment = Rounder.roundValue(model.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + currency + " " + payment;
            view.getOutput(output);
        } else  if (purchase.getDelivery() == 1){
            AppDeliveryModel model = new AppDeliveryModel();
            String payment = Rounder.roundValue(model.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + currency + " " + payment;
            view.getOutput(output);
        }
    }

    public Buyer getBuyer (String[] data){
        return new Buyer(data[0], data[1]);
    }
    private Purchase getPurchase(String[] data) {
        return new Purchase(Integer.parseInt(data[2]),
                Double.parseDouble(data[3]), Integer.parseInt(data[4]));
    }

}
