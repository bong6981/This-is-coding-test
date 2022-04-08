package doit.ch03_search_algorithms;

public class BinSearch {
    static int binSearch(int[] arr, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (arr[pc] == key) {
                return pc;
            } else if(arr[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        return -1;
    }
}
