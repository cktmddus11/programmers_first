package ex138477;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Ex138477_3 {
    public static void main(String[] args){
        int k = 4;                   // 20
        int []score = {30, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        Integer[] scores = new Integer[score.length];

        return IntStream.range(0, score.length)
                .peek(i -> scores[i] = score[i])
                .map(i -> {                                      /// Collections.reverseOrder 높은 점수순으로 오름차순 정렬.
                    Arrays.sort(scores, 0, i + 1, Collections.reverseOrder(Integer::compare));
                    return i < k ? scores[i] : scores[k -1];
                }) // k일 이전은 그냥 가장 최하위 점수.
                .toArray();




    }

}
