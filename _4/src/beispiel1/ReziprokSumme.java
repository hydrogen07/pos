package beispiel1;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ReziprokSumme {

    double[] array;

    public ReziprokSumme(int upperBound) {
        array = IntStream.range(1, upperBound+1).mapToDouble(i -> (double) 1/i).toArray();
    }

    public double calculate() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(new ReziprokTask(array));
    }
}
