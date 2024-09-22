import java.util.*;

public class SimpleQueue {
    int front, rear, capacity;
    int[] queue;

    //constructors
    SimpleQueue(int c){
        front = 0;
        rear = -1;
        capacity = c;
        queue = new int[capacity];
    }
    // Insert an element at the end of the queue
    void enqueue(int data){
        if (rear == capacity-1){
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = data;
    }
    //Delete an element from the queue
    void dequeue(){
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < rear; i++){
            queue[i] = queue[i+1];
        }
        // Decrement Rear
        rear--;
    }
    // Display
    void display() {
        if(front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        // Traverse front to rear and print elements
        for (int i = front; i<=rear; i++) {
            System.out.println(queue[i] + " <-- ");
        }
        System.out.println();
    }
    void front() {
        if (rear == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of queue: ");
        int c = scanner.nextInt();
        SimpleQueue q = new SimpleQueue(c);
        while (true){
            System.out.println("\n *** Simple Queue Menu ***");
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Display Queue");
            System.out.println("4. Front");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to push: ");
                    int data  = scanner.nextInt();
                    q.enqueue(data);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    q.front();
                    break;
                case 5:
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
