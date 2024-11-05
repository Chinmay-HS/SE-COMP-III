import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SecurePasswordStorageSystem {

    // Store username -> [hashed password, salt failed attempts]
    private static HashMap<String, String[]> userData = new HashMap<>();
    private static final int MAX_FAILED_ATTEMPTS = 3;

    // Method to generate salt (32-byte salt)
    public static String generateSalt() {
        byte[] salt = new byte[32];  // Longer salt for better security
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Password hashing using PBKDF2 with HMAC-SHA-256
    public static String hashPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        int iterations = 10000;  // Increase the number of iterations for more security
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = Base64.getDecoder().decode(salt);

        // Define the PBKDF2 key spec with the desired hash length (256-bit)
        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, 256);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedBytes = keyFactory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    // Register a new user
    public static void registerUser(String username, String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        // Ensure password is strong enough
        if (!isPasswordStrong(password)) {
            System.out.println("Password does not meet security criteria!");
            return;
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        userData.put(username, new String[]{hashedPassword, salt, "0"});
        System.out.println("User " + username + " registered successfully.");
    }

    // Check if the password meets complexity criteria
    public static boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }
        if (!password.matches(".*[!@#$%^&*].*")) {
            System.out.println("Password must contain at least one special character (!@#$%^&*).");
            return false;
        }
        return true;
    }

    // Verify the user's login attempt
    public static boolean verifyPassword(String username, String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        if (!userData.containsKey(username)) {
            System.out.println("Username not found.");
            return false;
        }

        String[] storedData = userData.get(username);
        String storedHash = storedData[0];
        String storedSalt = storedData[1];
        int failedAttempts = Integer.parseInt(storedData[2]);

        // Check if the account is locked
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            System.out.println("Account is locked due to multiple failed login attempts.");
            return false;
        }

        // Hash the entered password with the stored salt
        String enteredHash = hashPassword(password, storedSalt);

        // Check if the entered password hash matches the stored hash
        if (enteredHash.equals(storedHash)) {
            System.out.println("Password verified successfully!");
            userData.put(username, new String[]{storedHash, storedSalt, "0"});  // Reset failed attempts
            return true;
        } else {
            // Increment failed attempts
            failedAttempts++;
            userData.put(username, new String[]{storedHash, storedSalt, String.valueOf(failedAttempts)});
            System.out.println("Incorrect password. Failed attempts: " + failedAttempts);
            return false;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Console console = System.console();

        // Ensure the Console object is available
        if (console == null) {
            System.out.println("No console available. Please run this in a terminal environment.");
            System.exit(1);
        }

        while (true) {
            System.out.println("\n--- Secure Password Storage System ---");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            String choice = console.readLine("Choose an option: ");

            switch (choice) {
                case "1":
                    String username = console.readLine("Enter username: ");
                    char[] passwordArray = console.readPassword("Enter password: ");
                    String password = new String(passwordArray);
                    registerUser(username, password);
                    break;

                case "2":
                    username = console.readLine("Enter username: ");
                    passwordArray = console.readPassword("Enter password: ");
                    password = new String(passwordArray);
                    verifyPassword(username, password);
                    break;

                case "3":
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
