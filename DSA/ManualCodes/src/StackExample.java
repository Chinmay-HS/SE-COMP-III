import java.util.Scanner;

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    // Constructor to initialize the stack
    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;  // Stack is initially empty
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Push element into the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stackArray[++top] = value;
            System.out.println("Push -> " + value);
            display();
        }
    }

    // Pop element from the stack
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
        } else {
            int value = stackArray[top--];
            System.out.println("Pop -> " + value);
            display();
        }
    }

    // Peek at the top element of the stack
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
        } else {
            System.out.println("Peek -> Top element is: " + stackArray[top]);
            display();
        }
    }

    // Search for an element in the stack
    public void search(int value) {
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (stackArray[i] == value) {
                System.out.println("Element " + value + " found at position: " + (top - i + 1) + " from the top.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + value + " not found in the stack.");
        }
    }

    // Display the elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print("| " + stackArray[i] + " ");
            }
            System.out.println("|");
        }
    }

    // Menu-driven function for stack operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        ArrayStack stack = new ArrayStack(size);

        while (true) {
            System.out.println("\n*** Stack Menu ***");
            System.out.println("1. Push element");
            System.out.println("2. Pop element");
            System.out.println("3. Peek at top element");
            System.out.println("4. Search for an element");
            System.out.println("5. Display stack");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int searchElement = scanner.nextInt();
                    stack.search(searchElement);
                    break;

                case 5:
                    stack.display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
