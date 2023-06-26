package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class First {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        //System.out.printf("Array length: %d\n", Task1(new int[]{2, 3, 5, -2, 3}));
        //Task2();
        //Task3();
        Task4();
    }

    static int Task1(int[] arr){
        if(arr.length == 0) return -1;
        return arr.length;
    }


    /**
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
    1 done. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
    2 done. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
    3 done. если вместо массива пришел null, метод вернет -3
    4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
    Напишите метод, в котором реализуйте взаимодействие с пользователем.
    То есть, этот метод запросит искомое число у пользователя, вызовет первый,
    обработает возвращенное значение и покажет читаемый результат пользователю.
    Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
    */

    static void Task2(){
        while (true) {
            System.out.println("Enter value to search: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                int[] arr = new int[random.nextInt(5) + 1];
                if (random.nextInt(2) == 0) arr = null;
                if (arr != null) {
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = random.nextInt(10);
                        System.out.printf("%d \t", arr[i]);
                    }
                    System.out.println();
                }
                int res = processArray(arr, value);
                if (res == -1) System.out.println("Array length is less than 3");
                else if (res == -2) System.out.println("Value not found");
                else if (res == -3) System.out.println("Array is null");
                else System.out.printf("Value found at position %d\n", res);
                
            }
            else {
                System.out.println("Wrong input");
                scanner.next();
            }
        }
    }

    static int processArray(int[] arr, int value){
        if (arr == null) return -3;
        if (arr.length < 3) return -1;
        for (int el: arr) {
            System.out.printf("%d ", el);
        }
        System.out.println();
        int searchRes = Arrays.binarySearch(arr, value); // searching for value in arr; searchRes is a position of value in arr
        
        if (searchRes < 0) return -2;

        return searchRes;
    }


    /**
    * Implement a method that takes an integer two-dimensional array as an argument.
    * It is necessary to calculate and return the sum of the elements of this array.
    * At the same time, we impose 2 restrictions on the method: the method can only work with square arrays
    * (number of rows = number of columns), and each cell can contain only the value 0 or 1.
    * If one of the conditions is violated, the method should throw a RuntimeException with an error message.
    */

    static void Task3(){
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n ***Итерация %d ***\n\n", i+1);
            processArray(generateArray());
        }
     }

     static void processArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length){
                // throw new IOException();
                throw new RuntimeException("Некорректная размерность массива");
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1){
                    throw new RuntimeException(String.format("Некорректное значение массива по индексу: %d %d", i, j));
                }
                else{
                    sum += arr[i][j];
                }
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
     }


     static int[][] generateArray(){
        int[][] arr = new int[random.nextInt(2) + 5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(2);
                if (random.nextInt(1000) == 0)
                {
                    arr[i][j] = 2; // Намерненная ошибка
                }
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }


    /**
    Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    Необходимо посчитать и вернуть сумму элементов этого массива.
    При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
    (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
    Если нарушается одно из условий, метод должен вернуть код ошибки.
    Программа должна корректно обработать код ошибки и вывести соответствующее сообщение пользователю.
    Сравнить такой вариант обработки исключений с предыдущим.
    */

    static void Task4(){
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n ***Итерация %d ***\n\n", i+1);
            int errCode = processArray2(generateArray());
            if (errCode == -1) System.out.println("Некорректная размерность массива");
            else if (errCode == -2) System.out.println("Некорректное значение массива");
            else System.out.printf("Сумма элементов массива: %d\n", errCode);
        }
    }

    static int processArray2(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length){
                return -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1){
                    return -2;
                }
                else{
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
}