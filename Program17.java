// binary search in shorted array
public class Program17 {
    static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            return binarySearch(arr, mid + 1, high, key);
        else
            return binarySearch(arr, low, mid - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 10 };
        int key = 10;
        int n = arr.length;

        int result = binarySearch(arr, 0, n - 1, key);

        System.out.println("Index: " + result);
    }
}
