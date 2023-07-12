package practicalExam.Doctor.utils;

import java.util.Scanner;

public class Validator {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return getInt(null, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(int minRange, int maxRange) {
        return getInt(null, minRange, maxRange);
    }

    public static int getInt(String msg) {
        return getInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(String msg, int minRange, int maxRange) {
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        int value = Integer.MIN_VALUE;

        do {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please enter again...");
            }
        } while (value < minRange || value > maxRange);

        return value;
    }

    public static String getString(String msg, String pattern) {
        String value = null;

        do {
            value = getString(msg);
        } while (!value.matches(pattern));

        return value;
    }

    public static String getString(String msg) {
        String value = null;

        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().replaceAll("\\s+", " ").trim();

            if (!value.isEmpty() && !value.isBlank()) {
                break;
            }

            System.err.println("Please enter again...");
        }

        return value;
    }

    public static String inputString() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Please enter a non-empty string.");
        }
    }

    public static int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if ((input >= min) && (input <= max)) {
                    return input;
                }
                System.out.println("Invalid integer.");
            } catch (Exception InputMismatchException) {
                System.out.println("You did not enter an integer!");
                scanner.nextLine();
            }
        }
    }

    public static boolean inputYN() {
        while (true) {
            System.out.println("Enter y/Y or n/N.");
            String input = Validator.inputString();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            }
            else if (input.equalsIgnoreCase("N")) {
                return false;
            }
            else System.out.println("Invalid input. Try again.");
        }
    }

}

