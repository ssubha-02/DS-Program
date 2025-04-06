// rotation of array using function
public class Program11 {
    static void leftRotate(int arr[], int d) {
        if (d == 0) 
            return;

        int n = arr.length;
        d = d % n; 

        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) { 
            temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--;
        }
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 }; 
        int d = 2; 

        System.out.println("Original Array:");
        printArray(arr);

        leftRotate(arr, d);

        System.out.println("Left Rotated Array:");
        printArray(arr);
    }
}
