package beispiel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Calculator {
    public void calculate(int upperBound) {
        int partsAmount = upperBound/100+1;
        List<List<Integer>> parts = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 0; i < partsAmount; i++) {
            parts.add(new ArrayList<>());
            for (int j = 1; j <= 100 && j+i*100 <= upperBound; j++)
                parts.get(i).add(j+i*100);
        }
        List<Callable<Integer>> callables = new ArrayList<>();
        parts.forEach(x -> callables.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return x.stream().mapToInt(Integer::valueOf).sum();
            }
        }));
        List<Future<Integer>> futures = new ArrayList<>();
        try {
            futures = executor.invokeAll(callables);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println(futures.stream().mapToInt(x -> {
            try {
                return x.get();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }).sum());
        executor.shutdown();
        System.out.println((upperBound*upperBound+upperBound)/2);
    }
}
