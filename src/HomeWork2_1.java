//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork2_1 {
    public static void main(String[] args) {
        inputFloat();
    }

    public static void inputFloat() {
        try (Scanner sc = new Scanner(System.in)){
            double a = sc.nextFloat();
            System.out.println(a);
        } catch (InputMismatchException e) {
            System.out.println("Введите дробное число");
        }
    }
}
