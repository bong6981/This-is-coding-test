package etc.ref;

import java.util.*;

public class IntersectionUnion {
    public static void main(String[] args) {
        makeAnotherSet();
    }

    public static void makeAnotherSet() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        Set<Integer> gyo = new HashSet<>();
        Set<Integer> hap = new HashSet<>();

        hap.addAll(list1);
        hap.addAll(list2);

        gyo.addAll(list1);
        gyo.retainAll(list2);

        System.out.println(hap); // [1, 2, 3, 4, 5, 6]
        System.out.println(gyo); // [3, 4]

    }
}
