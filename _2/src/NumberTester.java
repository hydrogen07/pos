import java.io.*;
import java.util.*;

public class NumberTester {

    private ArrayList<int[]> input;
    private NumberTest oddEvenTester, primeTester, palindromeTester;

    public NumberTester(String fileName) {
        try (BufferedReader fIn = new BufferedReader(new FileReader(fileName))) {
            input = new ArrayList<>(Collections.nCopies(Integer.parseInt(fIn.readLine()), new int[2]));
            for (int[] cInput : input)
                cInput = Arrays.stream(fIn.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void testFile() {
        for (int[] cInput : input) {
            switch (cInput[0]) {
                case 1:
                    System.out.println(oddEvenTester.numberTest(cInput[1])); break;
                case 2:
                    System.out.println(primeTester.numberTest(cInput[1])); break;
                case 3:
                    System.out.println(palindromeTester.numberTest(cInput[1])); break;
                default:
                    System.out.println();
            }
        }
    }

    public void setOddEvenTest(NumberTest oddEvenTester) {
        this.oddEvenTester = oddEvenTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }
}
