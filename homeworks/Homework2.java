package homeworks;

import java.io.FileNotFoundException;

public class Homework2 {
    public static void main(String[] args) {
        //Task1();

        // Task 2:
        /* try {
            int[] intArray = new int[10];
            int catchedRes2 = intArray[10];
            System.out.println("catchedRes2 = " + catchedRes2);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        } */

        // Task 3:
        /* try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Файл не найден!");
        }
        catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
        finally {
            System.out.println("Этот текст будет напечатан в любом случае");
        } */


        Task4();

    }

    // Task 3:
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }


    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
    // Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    static void Task1(){
        float a = 0;
        boolean isCorrect = false;
        System.out.println("Введите дробное число:");
        while (!isCorrect) {
            try {
                a = Float.parseFloat(System.console().readLine());
                isCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Не верный вывод, попробуйте еще раз");
            }
        }
        System.out.println(a);
    }

    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, 
    // что пустые строки вводить нельзя.
    static void Task4(){
        String str = "";
        boolean isCorrect = false;
        System.out.println("Введите строку:");
        while (!isCorrect) {
            try {
                str = System.console().readLine();
                if (str.length() == 0) {
                    throw new Exception("Пустые строки вводить нельзя");
                }
                isCorrect = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(str);
    }
    
}
