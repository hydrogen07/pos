import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            list.add((char) (97 + i) + " ");
        for (String cList : list)
            System.out.print(cList);
        System.out.println();
        list.forEach((String s) -> System.out.print(s));
        System.out.println();
        list.forEach(System.out::print);


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
        numberTester.testFile();
    }
}
