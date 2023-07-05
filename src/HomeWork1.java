//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

import java.io.File;
import java.io.IOException;

public class HomeWork1 {
    public static void main(String[] args) {
        try {
            System.out.println(toDevide(10, 0));
        }catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        }
        try {
            IndexOutOfBound();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Слишком большой индекс!");
        }
        try {
            System.out.println(getNull());
        }catch (NullPointerException e){
            System.out.println("Строка отсутствует");
        }
    }
    public static int toDevide(int a1, int a2) {
            return a1 / a2;
    }
    public static void IndexOutOfBound(){
        int[] nums = new int[10];
        System.out.println(nums[nums.length]);
    }
    public static int getNull() {
        String str = null;
        return str.length();
    }
}

