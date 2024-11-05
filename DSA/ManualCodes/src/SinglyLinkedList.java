import java.util.Scanner;

public class SinglyLinkedList {
    // Represent a node of the singly linked list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    // Method to add a new node to the list
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to remove a node with a specific value
    public void removeNode(int data) {
        if (head == null) {
            System.out.println("List is empty. No nodes to remove.");
            return;
        }

        // If the node to be removed is the head
        if (head.data == data) {
            head = head.next; // Move head to the next node
            System.out.println("Node with data " + data + " removed.");
            return;
        }

        Node current = head;
        Node prev = null;

        // Traverse the list to find the node to be removed
        while (current != null && current.data != data) {
            prev = current;           // Store reference to the previous node
            current = current.next;   // Move to the next node
        }

        // If the node was not found
        if (current == null) {
            System.out.println("Node with data " + data + " not found.");
            return;
        }

        // If the node to be removed is found, update the next reference of the previous node
        prev.next = current.next;

        // If the removed node is the tail, update the tail reference
        if (current == tail) {
            tail = prev;
        }

        System.out.println("Node with data " + data + " removed.");
    }

    // Method to search for a node with a specific value
    public void searchNode(int data) {
        Node current = head;
        int position = 1;

        // Traverse the list to find the node
        while (current != null) {
            if (current.data == data) {
                System.out.println("Node with data " + data + " found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }

        // If the node was not found
        System.out.println("Node with data " + data + " not found in the list.");
    }

    // Method to display the list
    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Linked List:");
        while (current != null) {
            System.out.print("| " + current.data + " |" + (current.next != null ? " -> " : " -> null"));
            current = current.next;
        }
        System.out.println(); // Move to the next line after the entire list is printed
    }

    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("\n*** Singly Linked List Menu ***");
        System.out.println("1. Add Node");
        System.out.println("2. Remove Node");
        System.out.println("3. Search Node");
        System.out.println("4. Display List");
        System.out.println("5. Exit");
        // Menu loop to perform different operations on the list
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to add to the list: ");
                    int data = scanner.nextInt();
                    sList.addNode(data);
                    System.out.println("Node added successfully.");
                    break;

                case 2:
                    System.out.print("Enter data of the node to remove: ");
                    int removeData = scanner.nextInt();
                    sList.removeNode(removeData);
                    break;

                case 3:
                    System.out.print("Enter data of the node to search: ");
                    int searchData = scanner.nextInt();
                    sList.searchNode(searchData);
                    break;

                case 4:
                    sList.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5); // Exit when choice is 5

        scanner.close(); // Close the scanner resource
    }
}
