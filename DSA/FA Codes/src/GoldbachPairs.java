import java.util.Scanner;

class GoldbachPairs {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (10-49): ");
        int n = sc.nextInt();

        if (n <= 9 || n >= 50 || n % 2 != 0) {
            System.out.println("INVALID INPUT");
            return;
        }

        System.out.println("PRIME PAIRS ARE:");
        for (int i = 3; i <= n/2; i++)
            if (isPrime(i) && isPrime(n-i))
                System.out.println(i + ", " + (n-i));
    }
}