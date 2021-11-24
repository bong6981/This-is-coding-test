package etc.ref.set;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {
    public static void main(String[] args) {
        returnWhenAdd();
    }

    public static void returnWhenAdd() {
        Set<Integer> sets = new HashSet<>();
        sets.add(1);
        sets.add(2);
        sets.add(3);
        System.out.println(sets.add(4)); //true
        System.out.println(sets.add(1)); // false
    }
}
