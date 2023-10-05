package beispiel4;

public class VectorCalculator extends AbstractCalculator {

    public VectorCalculator() {
        super((x, y) -> {
                    Number n = new Number();
                    n.setA(x.getA()+y.getA());
                    n.setB(x.getB()+y.getB());
                    return n;},

                (x, y) -> {
                    Number n = new Number();
                    n.setA(x.getA()-y.getA());
                    n.setB(x.getB()-y.getB());
                    return n;},

                (x, y) -> {
                    Number n = new Number();
                    n.setA(x.getA()*y.getB()-x.getB()*y.getA());
                    n.setB(0);
                    return n;},

                (x, y) -> {
                    Number n = new Number();
                    n.setA(x.getA()*y.getA()+x.getB()*y.getB());
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
}
