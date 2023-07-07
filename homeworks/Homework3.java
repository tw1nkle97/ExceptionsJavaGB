package homeworks;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String lastName, firstName, middleName, phoneNumber;

            do {
                System.out.println("Введите Фамилию, Имя, Отчество и номер телефона через пробел:");

                String input = scanner.nextLine();
                String[] inputParts = input.split(" ");

                if (inputParts.length != 4) {
                    System.out.println("Вы ввели неправильное количество данных. Требуется ввести 4 элемента.");
                    continue;
                }

                lastName = inputParts[0];
                firstName = inputParts[1];
                middleName = inputParts[2];
                if (!lastName.matches("^[a-zA-Z]*$") || !firstName.matches("^[a-zA-Z]*$") || !middleName.matches("^[a-zA-Z]*$")) {
                    System.out.println("Введенные Фамилия, Имя или Отчество не на английском языке.");
                    continue;
                }

                try {
                    Long.parseLong(inputParts[3]);
                    phoneNumber = inputParts[3];
                } catch (NumberFormatException e) {
                    System.out.println("Введен неправильный формат номера телефона.");
                    continue;
                }

                break;
            } while (true);

            File file = new File(lastName + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(lastName + " " + firstName + " " + middleName + " " + phoneNumber);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Ваши данные успешно записаны в файл.");
        } finally {
            scanner.close();
        }
    }
}
