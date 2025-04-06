// left rotation using temporary array
public class Program9 {
    static void rotate(int arr[], int d, int n) 
{  
int temp[] = new int[n];
        int j = 0; 
  
        for (int i = d; i < n; i++) { 
            temp[j] = arr[i]; 
            j++; 
        } 
  
        for (int i = 0; i < d; i++) { 
            temp[j] = arr[i]; 
            j++; 
        } 
  
        for (int i = 0; i < n; i++) { 
            arr[i] = temp[i]; 
        } 
    } 
  
    static void printTheArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) { 
            System.out.print(arr[i] + " "); 
        } 
    } 
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 2, 3, 4, 5, 6 }; 
        int N = arr.length; 
        int d = 2; 
  
        rotate(arr, d, N); 
        printTheArray(arr, N); 
    } 
}
