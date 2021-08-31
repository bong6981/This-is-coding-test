package ch7_binary_search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ch7_5_FindParts {
    public static void main(String[] args) {
//        solution();
//        dongbinBinaryTree();
          dongbinCountingSort();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        //disticnt()로 중복제거
        //dongbin = 애초에 Set<Integer>로 만들었다.
        List<Integer> stock = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .distinct()
                .collect(Collectors.toList());
        int m = sc.nextInt();
        sc.nextLine();
        List<Integer> require  = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        for( int r : require) {
            if(stock.contains(r)) {
                System.out.print("yes ");
            }else{
                System.out.print("no ");
            }
        }
    }

    public static void dongbinBinaryTree() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        //disticnt()로 중복제거
        Integer[] stock = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .distinct()
                .sorted()
                .toArray(Integer[]::new);
        int m = sc.nextInt();
        sc.nextLine();
        Integer[] require  = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        for( int r : require) {
            if(binaryTree(stock, r, 0, stock.length)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

    public static boolean binaryTree(Integer[] arr, int target, int start, int end) {
        if(start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if( arr[mid] > target) {
            return binaryTree(arr, target, start, mid-1);
        } else if( arr[mid] == target ) {
            return true;
        } else {
            return binaryTree(arr, target, mid + 1, end);
        }
    }

    public static void dongbinCountingSort() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[1000001];
        //dongbin : for (int i = 0; i < n; i++) {
        //            int x = sc.nextInt();
        //            arr[x] = 1;
        //        }
        Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .forEach(x->arr[x] = 1);

        int m = sc.nextInt();
        sc.nextLine();
        Integer[] require  = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        for(int r : require) {
            if(arr[r] == 1) {
                System.out.print("yes ");
            }else{
                System.out.print("no ");
            }
        }
    }
}

/*
5
8 3 7 9 2
3
5 7 9
 */
