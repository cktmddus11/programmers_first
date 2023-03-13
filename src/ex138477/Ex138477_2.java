package ex138477;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex138477_2 {
    //https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
    public static void main(String[] args){
        int k = 4;
        int []score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0;i < score.length;i++){
            q.add(score[i]);
            if(q.size() > k){ // k번재 이후부터는 최하위 순위 꺼냄.
                q.poll();
            }
            answer[i] = q.peek();
        }


        return answer;

    }
}
