// /insert an element at the end of an array
public class Program14 {
    public static int insertSorted(int[] arr, int n, int key, int capacity) {
        if (n >= capacity)
            return n;

        arr[n] = key;
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;

        int n = 6; 
        int key = 26;
        int capacity = arr.length;

        System.out.print("Before Insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }

        n = insertSorted(arr, n, key, capacity);

        System.out.print("\nAfter Insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
