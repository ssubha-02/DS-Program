//insert an element at the bigining of array
import java.util.Scanner;

public class Program13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[100];
        int size, elem;

        System.out.print("Enter the size of the array: ");
        size = scanner.nextInt();

        System.out.print("Enter the Elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the element to be inserted: ");
        elem = scanner.nextInt();

        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = elem;
        size++;

        System.out.print("Array after inserting element: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
