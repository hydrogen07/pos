import beispiel2.HalloJavaMitForEach;
import beispiel3.NumberTester;
import beispiel4.AbstractCalculator;
import beispiel4.ComplexCalculator;
import beispiel4.Number;
import beispiel4.RationalCalculator;
import beispiel4.VectorCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HalloJavaMitForEach.print();

        System.out.println();

        NumberTester numberTester = new NumberTester("numbers.txt");
        numberTester.setOddEvenTest(number -> number%2 == 0);
        numberTester.setPrimeTester(number -> {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number%i == 0)
                    return false;
            }
            return true;
        });
        numberTester.setPalindromeTester(number -> {
            String s = String.valueOf(number);
            StringBuilder rev = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--)
                rev.append(s.charAt(i));
            return s.contentEquals(rev);
        });
        System.out.println();
        numberTester.testFile();

        System.out.println();

        Scanner scan = new Scanner(System.in);
        boolean rep = true;
        while (rep) {
            System.out.println("1 - Rational calculator");
            System.out.println("2 - Vector calculator");
            System.out.println("3 - Complex calculator");
            System.out.println("4 - Exit program");
            int input = Integer.parseInt(scan.nextLine());
            AbstractCalculator calc;
            Number[] numbers;
            Number res = null;
            switch (input) {
                case 1:
                    calc = new RationalCalculator();
                    numbers = calc.getNumbers();
                    break;
                case 2:
                    calc = new VectorCalculator();
                    numbers = calc.getNumbers();
                    break;
                case 3:
                    calc = new ComplexCalculator();
                    numbers = calc.getNumbers();
                    break;
                case 4:
                    rep = false;
                    continue;
                default:
                    System.out.println("Enter a valid option");
                    continue;
            }
            System.out.println("1 - Add");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");
            System.out.println("5 - Enter numbers again");
            input = Integer.parseInt(scan.nextLine());
            switch (input) {
                case 1:
                    res = calc.add(numbers[0], numbers[1]);
                    break;
                case 2:
                    res = calc.subtract(numbers[0], numbers[1]);
                    break;
                case 3:
                    res = calc.multiply(numbers[0], numbers[1]);
                    break;
                case 4:
                    res = calc.divide(numbers[0], numbers[1]);
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
            System.out.println("Solution:");
            System.out.println("x = " + res.getA());
            System.out.println("y = " + res.getB());
            System.out.println();
        }
    }
}
