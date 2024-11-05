import java.util.Scanner;
public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        int totalCharacters = inputString.length();
        int vowelCount = countVowels(inputString);
        String reversedString = reverseString(inputString);
        System.out.println("Total number of characters: " + totalCharacters);
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Reversed string: " + reversedString);
        scanner.close();
    }
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}