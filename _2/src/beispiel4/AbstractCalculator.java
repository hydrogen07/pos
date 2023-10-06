package beispiel4;

import java.util.Scanner;

public abstract class AbstractCalculator {

    protected CalculationOperation add, subtract, multiply, divide;

    public AbstractCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        this.add = add;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
    }

    public abstract Number add(Number x, Number y);
    public abstract Number subtract(Number x, Number y);
    public abstract Number multiply(Number x, Number y);
    public abstract Number divide(Number x, Number y);

    public Number[] getNumbers() {
        Scanner scan = new Scanner(System.in);
        String n1 = "", n2 = "", n3 = "", n4 = "";
        Number[] res = new Number[2];
        res[0] = new Number();
        System.out.println("Enter number x a");
        res[0].setA(Double.parseDouble(scan.nextLine()));
        System.out.println("Enter number x b");
        res[0].setB(Double.parseDouble(scan.nextLine()));
        res[1] = new Number();
        System.out.println("Enter number y a");
        res[1].setA(Double.parseDouble(scan.nextLine()));
        System.out.println("Enter number y b");
        res[1].setB(Double.parseDouble(scan.nextLine()));
        return res;
    }
}
