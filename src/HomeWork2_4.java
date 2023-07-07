//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя!!!

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork2_4 {
    public static void main(String[] args) {
        try {dontInputNull();
        }
        catch (IllegalArgumentException e){
            System.out.println("Пустые строки вводить нельзя!!!");
        }
    }
    public static void dontInputNull() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        a = a.trim();
        if (a.isEmpty()) {
            throw new IllegalArgumentException();
        }
        System.out.println(a);
    }
}
