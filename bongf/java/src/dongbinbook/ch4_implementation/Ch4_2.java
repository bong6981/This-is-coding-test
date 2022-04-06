package dongbinbook.ch4_implementation;

import java.util.Scanner;

public class Ch4_2 {
    public static void main(String[] args) {
        System.out.println(dongbin());
    }

    public static int dongbin() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        int c = 0;
        for (int i = 0; i < h+1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String s = "" + i + j + k;
                    if(s.contains("3")) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
