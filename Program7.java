// reverse an array using stack
import java.util.Stack;

public class Program7 {
    static void reverseArray(int arr[]) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        
        System.out.println("Original Array:");
        printArray(arr);
        
        reverseArray(arr);
        
        System.out.println("Reversed Array:");
        printArray(arr);
    }
}
