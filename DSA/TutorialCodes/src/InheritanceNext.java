import java.util.Scanner;
class Vehicle {
    protected String brand;
    protected int year;
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
        public void displayDetails() {
            System.out.println("Vehicle Brand: " + brand + ", Year: " + year);
        }
    }
class CarNew extends Vehicle {
    private String model;
    public CarNew(String brand, int year, String model) {
        super(brand, year);
        this.model = model;
    }
    @Override
    public void displayDetails() {
        System.out.println("Car Brand: " + brand + ", Year: " + year + ", Model: " + model);
    }
}
public class InheritanceNext {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = null;
        CarNew CarNew = null;
        System.out.println("\nChoose an operation:");
        System.out.println("1. Create a vehicle");
        System.out.println("2. Create a Car");
        System.out.println("3. Display vehicle details");
        System.out.println("4. Display CarNew details");
        System.out.println("5. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter vehicle year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    vehicle = new Vehicle(brand, year);
                    System.out.println("Vehicle created.");
                    break;
                case 2:
                    System.out.print("Enter Car brand: ");
                    String CarNewBrand = scanner.nextLine();
                    System.out.print("Enter Car year: ");
                    int CarNewYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Car model: ");
                    String CarNewModel = scanner.nextLine();
                    CarNew = new CarNew(CarNewBrand, CarNewYear, CarNewModel);
                    System.out.println("Car created.");
                    break;
                case 3:
                    if (vehicle != null) {
                        vehicle.displayDetails();
                    } else {
                        System.out.println("No vehicle has been created yet.");
                    }
                    break;
                case 4:
                    if (CarNew != null) {
                        CarNew.displayDetails();
                    } else {
                        System.out.println("No Car has been created yet.");
                    }
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