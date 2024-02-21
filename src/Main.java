import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        PrintWriter pw;
        try{
            pw = new PrintWriter("AlgorithmEfficiency.csv");
            for(int i = 25 ; i < 125 ; i++){
                for(int j = 0;j<5;j++){
                    int[] arr = generateRandomArray(i);
                    String s = i+","+insertionSort(arr)+","+selectionSort(arr)+","+bubbleSort(arr);
                    System.out.println(s);
                    pw.println(s);
                }
            }
            pw.close();
        }catch (IOException e){
            System.out.println("file not found");
            System.exit(1);
        }

    }
    public static int insertionSort(int[] nums){
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        int out = 0;
        for(int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int count = 1;
            while(i-count>-1 && temp<arr[i-count]){
                arr[i-count+1]=arr[i-count];
                count++;
                out++;
            }
            arr[i-count+1] = temp;
        }
        return out;
    }
    public static int selectionSort(int[] nums){
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        int out = 0;
        for(int i = 0; i<arr.length-1;i++){
            int minIndex = i;
            for(int j = i; j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
                out++;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return out;
    }
    public static int bubbleSort(int[] nums){
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        int n = arr.length;
        int iterations = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                iterations++;
            }
            if (!swapped) {
                break;
            }
        }
        return iterations;
    }
    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100); // Random integer between 0 and 99
        }
        return arr;
    }
}