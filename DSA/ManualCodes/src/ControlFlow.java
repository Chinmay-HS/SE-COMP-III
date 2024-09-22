import java.util.Scanner;

public class ControlFlow
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1. Decision Making Statements\n   1. if Statements");
        System.out.println("2. Loop Statements\n   1. do-while Loop\n   2. while Loop\n   3. for Loop\n   4. for-each Loop");
        System.out.println("3. Jump Statements\n   1. break Statement\n   2. continue Statement\n");
        System.out.println("Please select an option for Control Flow statements:");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                handleDecisionMaking(scanner);
                break;

            case 2:
                handleLoops(scanner);
                break;

            case 3:
                handleJumpStatements(scanner);
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private static void handleDecisionMaking(Scanner scanner)
    {
        System.out.println("Enter three numbers:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b && a > c) {
            System.out.println(a + " is the greatest among the three numbers.");
        } else if (b > c) {
            System.out.println(b + " is the greatest among the three numbers.");
        } else {
            System.out.println(c + " is the greatest among the three numbers.");
        }
    }

    private static void handleLoops(Scanner scanner) {
        System.out.println("You selected Loop Statements.");
        System.out.println("Enter '1', '2', '3', or '4' to see the respective loop:");

        int loopOption = scanner.nextInt();

        switch (loopOption) {
            case 1:
                handleWhileLoop(scanner);
                break;

            case 2:
                handleDoWhileLoop(scanner);
                break;

            case 3:
                handleForLoop(scanner);
                break;

            case 4:
                handleForEachLoop();
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private static void handleWhileLoop(Scanner scanner) {
        System.out.println("Enter the last term for the summation of n natural numbers:");
        int num = scanner.nextInt();
        int sum = 0;

        int i = 1;
        while (i <= num) {
            sum += i;
            i++;
        }

        System.out.println("The sum of natural numbers up to " + num + " is " + sum);
    }

    private static void handleDoWhileLoop(Scanner scanner) {
        System.out.println("Enter the last term for the summation of n natural numbers:");
        int num = scanner.nextInt();
        int sum = 0;

        int i = 1;
        do {
            sum += i;
            i++;
        } while (i <= num);

        System.out.println("The sum of natural numbers up to " + num + " is " + sum);
    }

    private static void handleForLoop(Scanner scanner) {
        System.out.println("Enter a number to print its multiplication table:");
        int n = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }

    private static void handleForEachLoop() {
        int[] arr = {2, 4, 6, 8, 10};

        for (int num : arr) {
            System.out.println(num);
        }
    }

    private static void handleJumpStatements(Scanner scanner) {
        System.out.println("You selected Jump Statements.");
        System.out.println("Enter '1' for break statement or '2' for continue statement:");

        int jumpOption = scanner.nextInt();

        switch (jumpOption) {
            case 1:
                handleBreakStatement();
                break;

            case 2:
                handleContinueStatement();
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private static void handleBreakStatement() {
        for (int i = 0; i <= 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("The loop was broken at i = 4.");
    }

    private static void handleContinueStatement() {
        for (int i = 0; i <= 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println("The number 4 was skipped.");
    }
}
