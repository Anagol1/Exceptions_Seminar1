//Задание 2. Добавила инициализацию массива

public class HomeWork2_2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            double[] intArray = new double [10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

}
