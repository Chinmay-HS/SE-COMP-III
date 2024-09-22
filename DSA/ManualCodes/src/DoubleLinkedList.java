import java.util.Scanner;
public class DoubleLinkedList {

    class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head, tail = null;
    public void addNode(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    public void removeNode(int value) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.data == value) {
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Node with value " + value + " not found.");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        }
        else if (current == tail) {
            tail = tail.previous;
            tail.next = null;
        }
        else {
            Node prevNode = current.previous;
            Node nextNode = current.next;
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
        }
        System.out.println("Node with value " + value + " removed.");
    }
    public void searchNode(int data) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Node with data " + data + " found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Node with data " + data + " not found in the list.");
    }
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list (Forward): ");
        while (current != null) {
            System.out.print("| " + current.data + " |" + (current.next != null ? " <-> " : " -> null"));
            current = current.next;
        }
        System.out.println();
        current = tail;
        System.out.println("Nodes of doubly linked list (Backward): ");
        while (current != null) {
            System.out.print("| " + current.data + " |" + (current.previous != null ? " <-> " : " -> null"));
            current = current.previous;
        }
        System.out.println();
    }
    public static void main(String args[]) {
        DoubleLinkedList dlist = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n*** Doubly Linked List Menu ***");
            System.out.println("1. Add Node");
            System.out.println("2. Remove Node");
            System.out.println("3. Search Node");
            System.out.println("4. Display List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to add to the list: ");
                    int data = scanner.nextInt();
                    dlist.addNode(data);
                    System.out.println("Node added successfully.");
                    break;

                case 2:
                    System.out.println("Enter data of the node to remove: ");
                    int removeData = scanner.nextInt();
                    dlist.removeNode(removeData);
                    break;

                case 3:
                    System.out.println("Enter data of the node to search");
                    int searchData = scanner.nextInt();
                    dlist.searchNode(searchData);
                    break;

                case 4:
                    dlist.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choioce. Please try again");
                    break;

            }
        } while (choice !=5);
        scanner.close();
    }
}

