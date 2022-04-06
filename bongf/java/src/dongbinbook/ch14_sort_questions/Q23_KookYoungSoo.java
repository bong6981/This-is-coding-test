package dongbinbook.ch14_sort_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.acmicpc.net/problem/10825
public class Q23_KookYoungSoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfStudents = sc.nextInt();
        Score[] scores = new Score[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            scores[i] = new Score(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score score1, Score score2) {
                if (score1.korean == score2.korean) {
                    if (score1.english == score2.english) {
                        if (score1.math == score2.math) {
                            return score1.student.compareTo(score2.student);
                        }
                        return -(score1.math - score2.math);
                    }
                    return score1.english - score2.english;
                }
                return -(score1.korean - score2.korean);
            }
        });

        for (Score score : scores) {
            System.out.println(score.student);
        }
    }

    static class Score {
        String student;
        int korean;
        int english;
        int math;

        public Score(String student, int korean, int english, int math) {
            this.student = student;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
