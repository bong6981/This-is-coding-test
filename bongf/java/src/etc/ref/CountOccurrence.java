package etc.ref;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountOccurrence {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 1, 1);
        int frequency = Collections.frequency(list1, 1);
        System.out.println(frequency); // 3
    }
}
