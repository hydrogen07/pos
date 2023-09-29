import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            list.add(String.valueOf((char)(97+i)));
        for (String cList : list)
            System.out.println(cList);
    }
}
