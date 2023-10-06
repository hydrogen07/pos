package beispiel4;

import java.util.Scanner;

public class RationalCalculator extends AbstractCalculator {

    public RationalCalculator() {
        super((x, y) -> {
            Number n = new Number();
            n.setA(x.getA()+y.getA());
            n.setB(0);
            return n;},

                (x, y) -> {
            Number n = new Number();
            n.setA(x.getA()-y.getA());
            n.setB(0);
            return n;},

                (x, y) -> {
            Number n = new Number();
            n.setA(x.getA()*y.getA());
            n.setB(0);
            return n;},

                (x, y) -> {
            Number n = new Number();
            n.setA(x.getA()/y.getA());
            n.setB(0);
            return n;});
    }

    @Override
    public Number add(Number x, Number y) {
        return super.add.calc(x, y);
    }

    @Override
    public Number subtract(Number x, Number y) {
        return super.subtract.calc(x, y);
    }

    @Override
    public Number multiply(Number x, Number y) {
        return super.multiply.calc(x, y);
    }

    @Override
    public Number divide(Number x, Number y) {
        return super.divide.calc(x, y);
    }

    @Override
    public Number[] getNumbers() {
        Scanner scan = new Scanner(System.in);
        String n1 = "", n2 = "";
        Number[] res = new Number[2];
        res[0] = new Number();
        System.out.println("Enter number x a");
        res[0].setA(Double.parseDouble(scan.nextLine()));
        res[1] = new Number();
        System.out.println("Enter number y a");
        res[1].setA(Double.parseDouble(scan.nextLine()));
        return res;
    }
}
