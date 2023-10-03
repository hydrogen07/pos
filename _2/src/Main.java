import _2.beispiel2.HalloJavaMitForEach;
import _2.beispiel3.NumberTester;

public class Main {

    public static void main(String[] args) {
        HalloJavaMitForEach.print();

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
    }
}
