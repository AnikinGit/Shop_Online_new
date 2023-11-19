package app;

import app.controller.AppController;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        AppController controller = new AppController();
        controller.getPayment();
    }
}
