/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 *
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * датарождения - строка формата dd.mm.yyyy
 * номертелефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 *
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 *
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 *
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
 *
 * <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 *
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 *
 * Не забудьте закрыть соединение с файлом.
 *
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

package seminar3;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeWork3 {

    public static void main(String[] args) throws IOException {

        try {
            makeRecord();
            System.out.println("success");
        } catch (FileSystemException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void makeRecord() throws Exception {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), \n" +
                "номер телефона (число без разделителей) и пол(символ латиницей f или m), " +
                "разделенные пробелом");

        String text;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            text = bf.readLine();
        } catch (IOException e) {
            throw new Exception("Ошибка при работе с консолью");
        }

        String[] array = text.split(" ");
        if (array.length != 6) {
            throw new Exception("Введены не все данные");
        }

        String surname = array[0];
        String name = array[1];
        String patronymic = array[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdate;
        try {
            birthdate = format.parse(array[3]);
        } catch (ParseException e) {
            throw new ParseException("Введите верную дату", e.getErrorOffset());
        }

        int phone;
        try {
            phone = Integer.parseInt(array[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат телефона");
        }

        String sex = array[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")) {
            throw new RuntimeException("Введите пол(символ латиницей f или m)");
        }

        String fileName = surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0) {
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, format.format(birthdate), phone, sex));
        } catch (IOException e) {
            throw new FileSystemException("Ошибка при работе с файлом");
        }

    }
}

