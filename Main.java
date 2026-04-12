import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Assignment 2");

        while (true) {
            System.out.print("\nSelect a task (1-6)");
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            sc.nextLine(); 


            switch (choice) {
                case 1: task1(sc); break;
                case 2: task2(sc); break;
                case 3: task3(sc); break;
                case 4: task4(sc); break;
                case 5: task5(sc); break;
                case 6: task6(sc); break;
                default: System.out.println("Invalid choice");
            }
        }
        System.out.println("Program finished");
    }

    // task 1
    static void task1(Scanner sc) {
        System.out.println("task 1");
        int n = sc.nextInt();
        List<List<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) row.add(sc.nextInt());
            lines.add(row);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(); 
            int y = sc.nextInt(); 
            try {
                System.out.println(lines.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR");
            }
        }
    }

    // task 2
    static void task2(Scanner sc) {
        System.out.println("task 2");
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(sc.nextInt());

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String cmd = sc.next();
            if (cmd.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x, y);
            } else if (cmd.equals("Delete")) {
                int x = sc.nextInt();
                list.remove(x);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : list) sb.append(val).append(" ");
        System.out.println(sb.toString().trim());
    }

    // task 3
    static void task3(Scanner sc) {
        System.out.println("task 3");
        int N = sc.nextInt();
        Deque<Integer> shelf = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int op = sc.nextInt();
            if (op == 1) shelf.addFirst(sc.nextInt());      // Push left
            else if (op == 2) shelf.addLast(sc.nextInt());  // Push right
            else if (op == 3) System.out.println(shelf.removeFirst()); // Pop left
            else if (op == 4) System.out.println(shelf.removeLast());  // Pop right
        }
    }

    // task 4
    static void task4(Scanner sc) {
        System.out.println("task 4");
        System.out.print("Enter numbers (space-separated): ");
        String line = sc.nextLine();
        
        Stack<Integer> stack = new Stack<>();
        for (String s : line.trim().split("\\s+")) {
            if (!s.isEmpty()) stack.push(Integer.parseInt(s));
        }

        reverseStack(stack);

        System.out.print("Reversed stack: ");
        StringBuilder sb = new StringBuilder();
        for (int val : stack) sb.append(val).append(" ");
        System.out.println(sb.toString().trim());
    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    // task 5
    static void task5(Scanner sc) {
        System.out.println("task 5");
        
        System.out.print("Students preferences (0 or 1): ");
        Queue<Integer> students = new ArrayDeque<>();
        for (String s : sc.nextLine().trim().split("\\s+"))
            if (!s.isEmpty()) students.add(Integer.parseInt(s));

        System.out.print("Samsas in stack (0 or 1, first is top): ");
        Stack<Integer> samsas = new Stack<>();
        String[] parts = sc.nextLine().trim().split("\\s+");

        for (int i = parts.length - 1; i >= 0; i--)
            if (!parts[i].isEmpty()) samsas.push(Integer.parseInt(parts[i]));

        int cycles = 0;
        while (!students.isEmpty() && !samsas.isEmpty()) {
            if (students.peek() == samsas.peek()) {
                students.poll();
                samsas.pop();
                cycles = 0;
            } else {
                students.add(students.poll());
                cycles++;
                if (cycles == students.size()) break;
            }
        }
        System.out.println("Students unable to eat: " + students.size());
    }

    // task 6
    static void task6(Scanner sc) {
        System.out.println("task 6");
        System.out.print("Enter array elements (space-separated): ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);

        buildMaxHeap(arr);

        System.out.print("Max-Heap array: ");
        StringBuilder sb = new StringBuilder();
        for (int val : arr) sb.append(val).append(" ");
        System.out.println(sb.toString().trim());
    }

    static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) heapify(arr, arr.length, i);
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}