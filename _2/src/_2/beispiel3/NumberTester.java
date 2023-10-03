package _2.beispiel3;

import java.io.*;
import java.util.*;

public class NumberTester {

    private ArrayList<ArrayList<String>> input;
    private NumberTest oddEvenTester, primeTester, palindromeTester;

    public NumberTester(String fileName) {
        try (BufferedReader fIn = new BufferedReader(new FileReader(fileName))) {
            input = new ArrayList<>(Integer.parseInt(fIn.readLine()));
            for (int i = 0; i < 5; i++)
                input.add(new ArrayList<>(2));
            for (ArrayList<String> cInput : input)
                cInput.addAll(List.of(fIn.readLine().split(" ")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void testFile() {
        for (ArrayList<String> cInput : input) {
            switch (Integer.parseInt(cInput.get(0))) {
                case 1:
                    System.out.println(oddEvenTester.numberTest(Integer.parseInt(cInput.get(1))) ? "EVEN" : "ODD"); break;
                case 2:
                    System.out.println(primeTester.numberTest(Integer.parseInt(cInput.get(1))) ? "PRIME" : "NO PRIME"); break;
                case 3:
                    System.out.println(palindromeTester.numberTest(Integer.parseInt(cInput.get(1))) ? "PALINDROME" : "NO PALINDROME"); break;
                default:
                    System.out.println("test");
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
