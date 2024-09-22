import java.util.Scanner;

class CircularQueue {
    int SIZE; // Size of Circular Queue
    int front, rear;
    int items[];

    // Constructor to initialize the queue size
    CircularQueue(int c) {
        SIZE = c;   // Initialize SIZE here
        items = new int[SIZE]; // Initialize the array with the given size
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    boolean isFull() {
        if ((front == 0 && rear == SIZE - 1) || (front == rear + 1)) {
            System.out.println("Queue is full");
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return true;
        }
        return false;
    }

    // Adding an element
    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Cannot insert " + element + " as the queue is full.");
        } else {
            if (front == -1) { // If queue is initially empty
                front = 0;
            }
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    // Removing an element
    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty. No element to remove.");
            return (-1);
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1; // Reset the queue after the last element is dequeued
            } else {
                front = (front + 1) % SIZE;
            }
            System.out.println("Removed -> " + element);
            return element;
        }
    }

    // Display the queue
    void display() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.print("Items -> ");
            int i;
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print(items[i] + " ");
            System.out.println(items[i]); // Print the last element (rear)
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int c = scanner.nextInt();
        CircularQueue q = new CircularQueue(c);

        while (true) {
            System.out.println("\n *** Circular Queue Menu ***");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Is the queue Full?");
            System.out.println("4. Is the queue Empty?");
            System.out.println("5. Display queue");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    q.enQueue(element);
                    break;

                case 2:
                    q.deQueue();
                    break;

                case 3:
                    if (q.isFull()) {
                        System.out.println("Yes, the queue is full.");
                    } else {
                        System.out.println("No, the queue is not full.");
                    }
                    break;

                case 4:
                    if (q.isEmpty()) {
                        System.out.println("Yes, the queue is empty.");
                    } else {
                        System.out.println("No, the queue is not empty.");
                    }
                    break;

                case 5:
                    q.display();
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
