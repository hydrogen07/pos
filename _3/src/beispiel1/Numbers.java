package beispiel1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Stream;

public class Numbers {

    public List<Integer> generateList() {
        try (Stream<String> stream = Files.lines(Path.of("numbers.csv"))) {
                return stream.map(line -> line.split(":"))
                        .flatMap(Arrays::stream)
                        .filter(this::isInteger)
                        .map(Integer::parseInt).toList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public void printDivisable(List<Integer> list, int chunks, int divisor) {
        List<List<Integer>> chunkList = splitList(list, chunks);
        ThreadPoolExecutor executor = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(chunks);
        chunkList.forEach(chunk -> executor.execute(new Runnable() {
            @Override
            public void run() {
                chunk.forEach(n -> {if (n%divisor==0)
                    System.out.println(n);});
            }
        }));
        executor.shutdown();
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private List<List<Integer>> splitList(List<Integer> list, int chunks) {
        List<List<Integer>> chunkList = new ArrayList<>();
        int groupSize = list.size()/chunks;
        for (int i = 0; i < chunks; i++) {
            if (i < chunks-1)
                chunkList.add(list.subList(i*groupSize, (i+1)*groupSize));
            else
                chunkList.add(list.subList(i*groupSize, list.size()));
        }
        return chunkList;
    }
}
