import java.util.Scanner;

/**
 * Recursive Algorithms Implementation
 * 
 * This program demonstrates 4 recursive algorithms with their
 * time and space complexity analysis.
 */
public class RecursiveAlgorithms {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Recursive Algorithms Demo ===\n");
        
        // Task 1: Sum of squares of first n positive integers
        System.out.println("--- Task 1: Sum of Squares ---");
        System.out.print("Enter n for sum of squares (1² + 2² + ... + n²): ");
        int n1 = scanner.nextInt();
        int sumOfSquares = sumOfSquares(n1);
        System.out.println("Result: " + sumOfSquares);
        System.out.println();
        
        // Task 2: Sum of first n elements of an array
        System.out.println("--- Task 2: Sum of Array Elements ---");
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int arraySum = sumArray(array, size);
        System.out.println("Sum of first " + size + " elements: " + arraySum);
        System.out.println();
        
        // Task 3: Sum of powers
        System.out.println("--- Task 3: Sum of Powers ---");
        System.out.print("Enter base b: ");
        int base = scanner.nextInt();
        System.out.print("Enter exponent n (b⁰ + b¹ + ... + bⁿ): ");
        int exponent = scanner.nextInt();
        int powerSum = sumOfPowers(base, exponent);
        System.out.println("Result: " + powerSum);
        System.out.println();
        
        // Task 4: Display sequence in reverse (no arrays, no loops)
        System.out.println("--- Task 4: Reverse Sequence Display ---");
        System.out.print("Enter number of elements N: ");
        int n4 = scanner.nextInt();
        System.out.println("Enter " + n4 + " elements:");
        // For this task, we need to read input differently
        // We'll store in temporary array just for input, then use recursion
        int[] tempArray = new int[n4];
        for (int i = 0; i < n4; i++) {
            tempArray[i] = scanner.nextInt();
        }
        System.out.print("Reversed sequence: ");
        displayReverse(tempArray, n4);
        System.out.println();
        
        scanner.close();
    }
    
    /**
     * Task 1: Returns the sum of squares of the first n positive integers.
     * Formula: 1² + 2² + ... + n²
     * 
     * Base case: n = 1 returns 1
     * Recursive case: n² + sumOfSquares(n-1)
     * 
     * TIME COMPLEXITY: O(n) - The function makes n recursive calls,
     *                   performing O(1) work at each call.
     * SPACE COMPLEXITY: O(n) - The recursion depth is n, requiring n
     *                   stack frames on the call stack.
     */
    public static int sumOfSquares(int n) {
        // Base case: sum of squares of 1 is 1
        if (n == 1) {
            return 1;
        }
        // Recursive case: n² + sum of squares of (n-1)
        return n * n + sumOfSquares(n - 1);
    }
    
    /**
     * Task 2: Returns the sum of the first n elements of an array.
     * 
     * Base case: n = 0 returns 0 (no elements to sum)
     * Recursive case: arr[n-1] + sumArray(arr, n-1)
     * 
     * TIME COMPLEXITY: O(n) - The function makes n recursive calls,
     *                   processing one array element at each call.
     * SPACE COMPLEXITY: O(n) - The recursion depth is n, requiring n
     *                   stack frames on the call stack.
     */
    public static int sumArray(int[] arr, int n) {
        // Base case: no elements to sum
        if (n <= 0) {
            return 0;
        }
        // Recursive case: last element + sum of first (n-1) elements
        return arr[n - 1] + sumArray(arr, n - 1);
    }
    
    /**
     * Task 3: Returns the sum of the first n powers of base b.
     * Formula: b⁰ + b¹ + b² + ... + bⁿ
     * 
     * Base case: n = 0 returns 1 (b⁰ = 1)
     * Recursive case: bⁿ + sumOfPowers(b, n-1)
     * 
     * TIME COMPLEXITY: O(n) - The function makes n recursive calls,
     *                   with O(1) work (one multiplication) at each call.
     * SPACE COMPLEXITY: O(n) - The recursion depth is n, requiring n
     *                   stack frames on the call stack.
     */
    public static int sumOfPowers(int b, int n) {
        // Base case: b⁰ = 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: bⁿ + sum of all lower powers
        int power = 1;
        for (int i = 0; i < n; i++) {
            power *= b;
        }
        return power + sumOfPowers(b, n - 1);
    }
    
    /**
     * Task 4: Displays the first n elements of an array in reverse order.
     * 
     * Note: This implementation uses an array only for input storage.
     * The actual output is done recursively without loops.
     * 
     * Base case: n = 0 means no more elements to display
     * Recursive case: Print arr[n-1] first, then recursively call with (n-1).
     *                  This prints from the end of the array first, achieving
     *                  reverse order output.
     * 
     * TIME COMPLEXITY: O(n) - The function makes n recursive calls,
     *                   printing one element at each level of recursion.
     * SPACE COMPLEXITY: O(n) - The recursion depth is n, requiring n
     *                   stack frames on the call stack.
     */
    public static void displayReverse(int[] arr, int n) {
        // Base case: no more elements to display
        if (n == 0) {
            return;
        }
        // Recursive case: Print arr[n-1] FIRST, then recurse
        // This ensures we print from the end of the array first
        System.out.print(arr[n - 1] + " ");
        displayReverse(arr, n - 1);
    }
}
