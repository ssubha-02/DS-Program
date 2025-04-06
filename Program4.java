// REvrese an Array using an extra array

public class Program4 {
    public static void reverseArrayExtraArray(int[] arr) {
        int size = arr.length;
        int[] reversedArr = new int[size];
        
        for (int i = 0; i < size; i++) {
            reversedArr[i] = arr[size - i - 1];
        }
        
        System.out.print("Reversed Array: ");
        for (int i = 0; i < reversedArr.length; i++) {
            System.out.print(reversedArr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] originalArr = {1, 2, 3, 4, 5};
        reverseArrayExtraArray(originalArr);
    }
}
