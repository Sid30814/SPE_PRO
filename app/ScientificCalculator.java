import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class ScientificCalculator {
    // Setting up logging for the Monitoring requirement (Source 21, 22)
    private static final Logger logger = Logger.getLogger(ScientificCalculator.class.getName());

    static {
        try {
            // Generates the log file for the mini project (Source 22)
            FileHandler fh = new FileHandler("calculator.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            System.err.println("Error initializing log file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Application started."); // Source 21

        while (true) {
            // User menu driven operations (Source 4)
            System.out.println("\n--- Scientific Calculator (CS 816) ---");
            System.out.println("1. Square root function (√x)");
            System.out.println("2. Factorial function (x!)");
            System.out.println("3. Natural logarithm (ln(x))");
            System.out.println("4. Power function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                logger.info("Application exited by user.");
                break;
            }

            double result;
            switch (choice) {
                case 1: // Square root function - √x (Source 5)
                    System.out.print("Enter x: ");
                    double x1 = scanner.nextDouble();
                    if (x1 < 0) {
                        System.out.println("Error: Negative input.");
                        logger.warning("Square root error: Negative input " + x1);
                    } else {
                        result = Math.sqrt(x1);
                        System.out.println("Result: " + result);
                        logger.info("Square Root of " + x1 + " = " + result);
                    }
                    break;

                case 2: // Factorial function - x! (Source 6)
                    System.out.print("Enter x (integer): ");
                    int x2 = scanner.nextInt();
                    if (x2 < 0) {
                        System.out.println("Error: Negative input.");
                        logger.warning("Factorial error: Negative input " + x2);
                    } else {
                        long factResult = calculateFactorial(x2);
                        System.out.println("Result: " + factResult);
                        logger.info("Factorial of " + x2 + " = " + factResult);
                    }
                    break;

                case 3: // Natural logarithm (base e) ln(x) (Source 7)
                    System.out.print("Enter x: ");
                    double x3 = scanner.nextDouble();
                    if (x3 <= 0) {
                        System.out.println("Error: Input must be > 0.");
                        logger.warning("Log error: Non-positive input " + x3);
                    } else {
                        result = Math.log(x3);
                        System.out.println("Result: " + result);
                        logger.info("Natural Log of " + x3 + " = " + result);
                    }
                    break;

                case 4: // Power function - x^b (Source 8)
                    System.out.print("Enter base (x): ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent (b): ");
                    double exponent = scanner.nextDouble();
                    result = Math.pow(base, exponent);
                    System.out.println("Result: " + result);
                    logger.info("Power: " + base + "^" + exponent + " = " + result);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    public static long calculateFactorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}