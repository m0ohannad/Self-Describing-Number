package self;

import java.util.Scanner;

/**
 * @author Mohannad 🗡
 */

public class Self {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n"
                + "==============================\n"
                + "Check Self Descriptive Number\n"
                + "==============================\n");

        System.out.println("Hint: some examples of a self-descriptive number:\n"
                         + "(2020, 1210, 21200, 521001000)\n");

        System.out.println("Enter a Nuber: ");
        int number = input.nextInt();
        int length = String.valueOf(number).length();
        while (length <= 3) {
            System.out.println("Try to enter a number more than 3 digits: ");
            number = input.nextInt();
            length = String.valueOf(number).length();
        }

        if (isSelfDescriptiveNumber(number, length)) {
            System.out.println("So the number is self-describing ✔");
        } else {
            System.out.println("So the number is Not self-describing ✘");
        }
    }

    private static boolean isSelfDescriptiveNumber(int number, int length) {
        int n = number;
        int l = length;
        int Digit;
        while (n > 0) {
            Digit = n % 10;
            System.out.print("Is the number " + (l - 1) + " repeated " + Digit + " times? ");

            if (!isSelfDescriptive(number, l - 1, Digit)) {
                System.out.println("No ✘");
                return false;
            }
            
            System.out.println("Yes ✔");
            n = n / 10;
            l--;
        }
        return true;
    }

    private static boolean isSelfDescriptive(int n, int position, int Digit) {
        boolean isSelf = false;
        int count = 0;
        while (n > 0 && count < Digit) {
            int lastDigit = n % 10;
            if (lastDigit == position) {
                count++;
            }
            n = n / 10;
        }
        if (count == Digit) {
            isSelf = true;
        }
        return isSelf;
    }

}
