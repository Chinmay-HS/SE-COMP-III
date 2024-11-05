import java.util.Scanner;

class CharacterMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (4-9): ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (n < 4 || n > 9) {
            System.out.println("INVALID INPUT");
            return;
        }

        char[] chars = new char[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter character " + (i+1) + ": ");
            chars[i] = sc.nextLine().charAt(0);
        }

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == n-1)
                    matrix[i][j] = (i == 0 || i == n-1) && (j == 0 || j == n-1) ? chars[0] : chars[1];
                else
                    matrix[i][j] = chars[2];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}