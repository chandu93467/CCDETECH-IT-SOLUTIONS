import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator!");

        while (true) {
            try {
                double num1 = getNumberInput("Enter the first number: ");
                double num2 = getNumberInput("Enter the second number: ");

                String operation = getOperationInput();

                if (operation.equals("exit")) {
                    System.out.println("Exiting the calculator. Goodbye!");
                    break;
                }

                double result = performOperation(num1, num2, operation);

                System.out.println("Result: " + result);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers.");
                scanner.next(); // Consume the invalid input
            }
        }

        scanner.close();
    }

    private static double getNumberInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextDouble();
    }

    private static String getOperationInput() {
        System.out.print("Choose operation (+, -, *, /) or 'exit' to end: ");
        return new Scanner(System.in).next();
    }

    private static double performOperation(double x, double y, String operation) {
        switch (operation) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                if (y != 0) {
                    return x / y;
                } else {
                    System.out.println("Error: Division by zero");
                    return Double.NaN;
                }
            default:
                System.out.println("Invalid operation. Please choose a valid operation.");
                return Double.NaN;
        }
    }
}
