import java.util.Arrays;
import java.util.Scanner;

public class TasksSolution {
    
    public static String checkAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    public static int findKthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
    
    public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2;
        } else {
            return arr[n / 2];
        }
    }
    
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;  
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }
    
    private static boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int daysNeeded = 1;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > capacity) {
                daysNeeded++;
                currentLoad = weight;
                if (daysNeeded > days) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 Anagram Sort Checker");
        System.out.println("2 K-th Smallest Element");
        System.out.println("3 Median Element");
        System.out.println("4 Optimal Shipping Capacity");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("task 1");
                System.out.print("Enter first string ");
                String str1 = scanner.next();
                System.out.print("Enter second string ");
                String str2 = scanner.next();
                System.out.println("Output " + checkAnagram(str1, str2));
                break;
            case 2:
                System.out.println("task 2");
                System.out.print("Enter array size ");
                int size2 = scanner.nextInt();
                int[] arr2 = new int[size2];
                System.out.print("Enter " + size2 + " numbers ");
                for (int i = 0; i < size2; i++) {
                    arr2[i] = scanner.nextInt();
                }
                System.out.print("Enter k ");
                int k = scanner.nextInt();
                System.out.println("Output " + findKthSmallest(arr2.clone(), k));
                break;
            case 3:
                System.out.println("task 3");
                System.out.print("Enter array size ");
                int size3 = scanner.nextInt();
                int[] arr3 = new int[size3];
                System.out.print("Enter " + size3 + " numbers ");
                for (int i = 0; i < size3; i++) {
                    arr3[i] = scanner.nextInt();
                }
                System.out.println("Output " + findMedian(arr3.clone()));
                break;
            case 4:
                System.out.println("task 4");
                System.out.print("Enter number of packages ");
                int n = scanner.nextInt();
                int[] weights = new int[n];
                System.out.print("Enter package weights ");
                for (int i = 0; i < n; i++) {
                    weights[i] = scanner.nextInt();
                }
                System.out.print("Enter number of days ");
                int days = scanner.nextInt();
                System.out.println("Output " + shipWithinDays(weights, days));
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }
}
