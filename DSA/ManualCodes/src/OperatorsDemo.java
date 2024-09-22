import javax.sound.midi.SysexMessage;
import java.util.Scanner;
public class OperatorsDemo {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Demonstration of Operators in Java");

        do {
            System.out.println("Menu:");
            System.out.println("1. Arithmetic Operators");
            System.out.println("2. Unary Operators");
            System.out.println("3. Assignment Operators");
            System.out.println("4. Comparison Operators");
            System.out.println("5. Logical Operators");
            System.out.println("6. Ternary Operator");
            System.out.println("7. Bitwise Operators");
            System.out.println("8. Shift Operators");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.println("Addition Result: " + (num1 + num2));
                    System.out.println("Subtraction Result: " + (num1 - num2));
                    System.out.println("Multiplication Result: " + (num1 * num2));
                    System.out.println("Division Result: " + (num1 / num2));
                    System.out.println("Modulus Result: " + (num1 % num2));
                    break;

                case 2:
                    System.out.println("Enter first number: ");
                    double num7 = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double num8 = scanner.nextDouble();
                    System.out.println("Post Increment:" + (num7++));
                    System.out.println("Pre Increment" + (++num7));
                    System.out.println("Post Decrement" + (num8--));
                    System.out.println("Pre Decrement" + (--num8));
                    break;

                case 3:
                    System.out.println("Enter a number: ");
                    int num3 = scanner.nextInt();
                    System.out.println("f += 3: " + (num3 += 3));
                    System.out.println("f -= 2: " + (num3 -= 2));
                    System.out.println("f *= 4: " + (num3 *= 4));
                    System.out.println("f /= 3: " + (num3 /= 3));
                    System.out.println("f %= 2: " + (num3 %= 2));
                    System.out.println("f &= 0b1010: " + (num3 &= 0b1010));
                    System.out.println("f |= 0b1100: " + (num3 |= 0b1100));
                    System.out.println("f ^= 0b1010: " + (num3 ^= 0b1010));
                    System.out.println("f <<= 2: " + (num3 <<= 2));
                    System.out.println("f >>= 1: " + (num3 >>= 1));
                    System.out.println("f >>>= 1: " + (num3 >>>= 1));
                    break;

                case 4:
                    System.out.println("Enter first number: ");
                    double num4 = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double num5 = scanner.nextDouble();
                    System.out.println("a > b: " + (num4 > num5));
                    System.out.println("a < b: " + (num4 < num5));
                    System.out.println("a >= b: " + (num4 >= num5));
                    System.out.println("a <= b: " + (num4 <= num5));
                    System.out.println("a == c: " + (num4 == num5));
                    System.out.println("a!= c: " + (num4 != num5));
                    break;

                case 5:
                    boolean x = true;
                    boolean y = false;
                    System.out.println("x && y: " + (x && y));
                    System.out.println("x || y: " + (x || y));
                    System.out.println("!x:" +(!x));
                    break;

                case 6:
                    System.out.println("Enter first number: ");
                    double a = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double b = scanner.nextDouble();
                    System.out.println("Enter second number: ");
                    double c = scanner.nextDouble();
                    double result;
                    result = ((a > b)? (a > c)? a : c : (b > c) ? b : c);
                    System.out.println("Max of three numbers = "+ result);
                    break;
                case 7:
                    int d = 0b1010;
                    int e = 0b1100;
                    System.out.println("d & e: " + (d & e));
                    System.out.println("d | e: " + (d | e));
                    System.out.println("d ^ e: " + (d ^ e));
                    System.out.println("~d: " + (~d));
                    System.out.println("d << 2: " + (d << 2));
                    System.out.println("e >> 1: " + (e >> 1));
                    System.out.println("e >>> 1: " + (e >>> 1));
                    break;
                case 8:
                    System.out.println("Enter a number: ");
                    int g = scanner.nextInt();
                    // using left shift
                    System.out.println("a<<1: " + (g << 1));
                    // using right shift
                    System.out.println("a>>1: " + (g >> 1));
                    break;
                default:
                    System.out.println("Invalid Choice. Please select a valid option");
            }
        } while (choice !=8);
        scanner.close();
    }
}
