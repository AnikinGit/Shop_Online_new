package app.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppView {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public String[] getData() throws IOException {
        System.out.print("Введите свое имя: ");
        String name = bufferedReader.readLine();
        System.out.print("Введите свой номер телефона: ");
        String phone = bufferedReader.readLine();
        System.out.print("Введите количество товара: ");
        String quantity = bufferedReader.readLine();
        System.out.print("Введите цену товара: ");
        String price = bufferedReader.readLine();
        System.out.println("Если Вы хотите забрать товар сами - нажмите 0, если хотите, чтоб доствку сделали мы - нажмите 1");
        String delivery = bufferedReader.readLine();
        return new String[]{name, phone, quantity, price, delivery};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
