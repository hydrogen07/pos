import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberTester {

    private List<int[]> input;
    private NumberTest oddEvenTester;

    public NumberTester(String fileName) {
        try (BufferedReader fIn = new BufferedReader(new FileReader(new File(fileName)))) {
            input = new ArrayList<>(Integer.parseInt(fIn.readLine()));
            for (int[] cInput : input) {
                cInput = new int[]{Integer.parseInt(Arrays.toString(fIn.readLine().split(" ")))};
                System.out.println(cInput);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setOddEvenTest(NumberTest oddEvenTester) {
        this.oddEvenTester = oddEvenTester;
    }
}
