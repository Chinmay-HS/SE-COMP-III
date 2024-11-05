class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class ExceptionHandling {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is not valid for voting.");
        } else {
            System.out.println("You are eligible to vote.");
        }
    }
    public static void main(String[] args) {
        try {
            int age = 16;
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("This is the 'finally' block.");
        }
    }
}