package _2.beispiel2;

import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {

    public static void print() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            list.add((char) (97 + i) + " ");
        for (String cList : list)
            System.out.print(cList);
        System.out.println();
        list.forEach((String s) -> System.out.print(s));
        System.out.println();
        list.forEach(System.out::print);
    }
}
