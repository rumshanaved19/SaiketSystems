package SAIKETINTERN;
import java.util.InputMismatchException;
import java.util.Scanner;

public class saiket_task1
{
    public enum Operator 
    {
        ADD('+'),
        SUBTRACT('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        private final char symbol;

        Operator(char symbol)
        {
            this.symbol = symbol;
        }

        public double apply(double a, double b) 
        {
            switch (this) 
            {
                case ADD:
                    return a + b;
                case SUBTRACT:
                    return a - b;
                case MULTIPLY:
                    return a * b;
                case DIVIDE:
                   
                    if (b == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    return a / b;
                default:
                    
                    throw new UnsupportedOperationException("Unknown operation: " + this);
            }
        }

        public static Operator fromSymbol(char symbol) 
        {
            for (Operator op : values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            return null; 
        }
    }
    public static void main(String[] args)
     {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("---  Welcome to the Unique Java Calculator ---");
            boolean keepRunning = true;

            while (keepRunning)
             {
                try
                {
                    
                    System.out.print("\nEnter the first number: ");
                    double num1 = scanner.nextDouble();

                    System.out.print("Enter an operator (+, -, *, /): ");
                    char opSymbol = scanner.next().charAt(0);

                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();

                    Operator operation = Operator.fromSymbol(opSymbol);

                    if (operation != null) {
                        double result = operation.apply(num1, num2);
                        System.out.printf(" Result: %.2f %c %.2f = %.2f\n", num1, opSymbol, num2, result);
                    } 
                    else
                    {
                        System.out.println(" Error: Invalid operator. Please use one of: +, -, *, /");
                    }

                } 
                catch (InputMismatchException e)
                 {
                    System.out.println(" Error: Invalid input. Please enter numbers only.");
                    scanner.next(); 
                } catch (ArithmeticException e)
                {
                    System.out.println(" Error: " + e.getMessage());
                }

                System.out.print("\nPerform another calculation? (yes/no): ");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes"))
                 {
                    keepRunning = false;
                }
            }
            System.out.println("\n--- Thank you for using the calculator! ---");
        }
    }
}

