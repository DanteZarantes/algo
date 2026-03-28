import java.util.Scanner;

public class assignment1 {

    // task 1
    // complexity O(n) (recursion depth)
    // explanation we make n recursion decreasing n by 1 each time
    public static int sumOfSquares(int n) {
        if (n == 1) {
            return 1;
        }
        return n * n + sumOfSquares(n - 1);
    }

    // task 2
    // complexity O(n) (recursion depth)
    // explanation we traverse the array recursively from last element to first
    public static int sumOfArray(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        return arr[n - 1] + sumOfArray(arr, n - 1);
    }

    // task 3
    // complexity O(n) (recursion depth)
    // explanation we calculate each power and add them recursively
    public static int sumOfPowers(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return (int) Math.pow(b, n) + sumOfPowers(b, n - 1);
    }

    // task 4
    // complexity O(n) (recursion depth)
    // explanation first read all numbers recursively then print them on return
    public static void printReverse(int n, Scanner scanner) {
        if (n == 0) {
            return;
        }
        
        int num = scanner.nextInt();
        printReverse(n - 1, scanner);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 1
        System.out.println("Task 1: Sum of squares");
        System.out.print("Enter n: ");
        int n1 = scanner.nextInt();
        System.out.println(sumOfSquares(n1));
        System.out.println();

        //task 2
        System.out.println("Task 2: Sum of array elements");
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter n (number of elements to sum): ");
        int n2 = scanner.nextInt();
        System.out.println(sumOfArray(arr, n2));
        System.out.println();

        //task 3
        System.out.println("Task 3: Sum of powers");
        System.out.print("Enter base b: ");
        int b = scanner.nextInt();
        System.out.print("Enter n: ");
        int n3 = scanner.nextInt();
        System.out.println(sumOfPowers(b, n3));
        System.out.println();

        //task 4
        System.out.println("Task 4: Reverse sequence");
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        System.out.println("Enter " + N + " numbers:");
        printReverse(N, scanner);
        System.out.println();

        scanner.close();
    }
}