package beispiel1;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ReziprokTask extends RecursiveTask<Double> {

    double[] array;

    public ReziprokTask(double[] array) {
        this.array = array;
    }


    @Override
    protected Double compute() {
        if (array.length <= 2) {
            double sum = 0;
            for (double cDouble : array) {
                sum += cDouble;
            }
            return sum;
        } else {
            int mid = array.length/2;
            ReziprokTask left = new ReziprokTask(Arrays.copyOfRange(array, 0, mid));
            ReziprokTask right = new ReziprokTask(Arrays.copyOfRange(array, mid, array.length));
            invokeAll(left, right);
            Double resultLeft = left.join();
            Double resultRight = right.join();
            return resultLeft + resultRight;
        }
    }
}
