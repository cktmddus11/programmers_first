package ex42626;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex42626_2 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;


        System.out.println(solution(scoville, k));

    }

    public static int solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i<scoville.length;i++){
            heap.add(scoville[i]);
        }

        int loopCnt = 0;
        while(true){

            int min = heap.peek();

            if(min >= K){
                break;
            }else if(min < K && heap.size() == 1){
                loopCnt = -1;
                break;
            }
            int first = heap.poll();
            int next =  heap.poll();
            int result = first + next * 2;
            heap.add(result);
            loopCnt++;
        }
        answer = loopCnt;
        return answer;
    }
}


/*
* K 이상으로 만들기 위해 Leo는 스코빌 지수가 [가장 낮은 두 개]의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
*섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
*
*Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
* 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는
* 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
* */