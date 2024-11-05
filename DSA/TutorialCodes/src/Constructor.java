import java.util.Scanner;
class Car {
    private String brand;
    private String model;
    private int year;
    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.year = 2020;
    }
        public void displayDetails() {
            System.out.println("Car Brand: " + brand + ", Model: " + model + ", Year: " + year);
        }
    }

public class Constructor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car1 = null;
        Car car2 = null;
        Car car3 = null;
        System.out.println("\nChoose an operation:");
        System.out.println("1. Create a car using the default constructor");
        System.out.println("2. Create a car using the parameterized constructor");
        System.out.println("3. Create a car using the overloaded constructor");
        System.out.println("4. Display all cars");
        System.out.println("5. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    car1 = new Car();
                    System.out.println("Car created using the default constructor.");
                    break;
                case 2:
                    System.out.print("Enter car brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter car year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    car2 = new Car(brand, model, year);
                    System.out.println("Car created using the parameterized constructor.");
                    break;
                case 3:
                    System.out.print("Enter car brand: ");
                    String brandOverload = scanner.nextLine();
                    System.out.print("Enter car model: ");
                    String modelOverload = scanner.nextLine();
                    car3 = new Car(brandOverload, modelOverload);
                    System.out.println("Car created using the overloaded constructor.");
                    break;
                case 4:
                    System.out.println("\nCar Details:");
                    if (car1 != null)
                        car1.displayDetails();
                    if (car2 != null)
                        car2.displayDetails();
                    if (car3 != null)
                        car3.displayDetails();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}