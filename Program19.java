// delete an element in a sorted array
public class Program19 {
    static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binarySearch(arr, mid + 1, high, key);
        } else {
            return binarySearch(arr, low, mid - 1, key);
        }
    }

    static int deleteElement(int[] arr, int n, int key) {
        int pos = binarySearch(arr, 0, n - 1, key);

        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return n - 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;
        int key = 30;

        System.out.println("Array before deletion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        n = deleteElement(arr, n, key);

        System.out.println("\n\nArray after deletion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
