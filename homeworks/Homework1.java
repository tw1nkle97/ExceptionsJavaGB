package homeworks;


public class Homework1 {
    public static void main(String[] args) {
        //Task1_1();
        //Task1_2();
        //Task1_3();
        Task2(new int[]{1, 1, 1}, new int[]{1, 2, 3});
    }

    // Implement 3 methods to get different exceptions in each of them. F.e.: 5/0; 
    static void Task1_1(){
        int a = 5 / 0;
    }

    static void Task1_2(){
        int[] arr = new int[5];
        arr[6] = 5;
    }

    static void Task1_3(){
        int[][] arr = new int[5][5];
        arr[0][0] = 5 / 0;
    }

    // Implement a method that takes two integer arrays as arguments and returns a new array, each element of which is equal to the difference between the 
    // elements of two incoming arrays in the same cell. If the array lengths are not equal, it is necessary to notify the user somehow.

    static void Task2(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) {
            System.out.println("Arrays have different lengths");
            return;
        }
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i] - arr2[i];
        }
        for (int element: arr3) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }
}