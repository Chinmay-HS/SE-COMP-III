import java.util.Scanner;
class Student {
    private String name;
    private int age;
    private String grade;
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
        public void displayDetails() {
            System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
        }
    }
public class ArrayOfObjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int studentCount = 0;
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter details for the new student:");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    if (studentCount < students.length) {
                        students[studentCount] = new Student(name, age, grade);
                        studentCount++;
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Unable to add more students. Array is full.");
                    }
                    break;
                case 2:
                    if (studentCount == 0) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("\nDetails of all students:");
                        for (int i = 0; i < studentCount; i++) {
                            students[i].displayDetails();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}