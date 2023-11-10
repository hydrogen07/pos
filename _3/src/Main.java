import beispiel1.Numbers;
import beispiel2.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Numbers n = new Numbers();
        System.out.println("chunks");
        int chunks = Integer.parseInt(scan.nextLine());
        System.out.println("divisor");
        int divisor = Integer.parseInt(scan.nextLine());
        n.printDivisable(n.generateList(), chunks, divisor);

        Thread.sleep(1000);
        System.out.println();

        Calculator calc = new Calculator();
        calc.calculate(300);
    }
}
