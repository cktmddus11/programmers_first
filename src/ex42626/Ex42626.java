package ex42626;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


// XXXXXXXXXXXXXXXX
public class Ex42626 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;


        System.out.println(solution(scoville, k));

    }

    public static int solution(int[] scoville, int K) {

        int cnt = 0;
        while(Arrays.stream(scoville).boxed().anyMatch(i -> i < 7)){

            PriorityQueue<Integer> queue = new PriorityQueue<>(); // 오름차순 정렬.
            for(int s : scoville){  //add할때마다 재정렬하기 때문에 array 를 새로 매번만들필요가없음...........
                queue.add(s);
            }
            int mostSpicyValue = queue.poll();
            int secondSpicyValue = queue.poll();
            int newFoodScovileValue = mostSpicyValue + (secondSpicyValue * 2);

            int newScoville[] = new int[scoville.length-1];
            newScoville[0] = newFoodScovileValue;
            System.arraycopy(scoville, 2, newScoville, 1, queue.size());

            scoville = newScoville;

           System.out.println(cnt +">>>"+Arrays.toString(scoville));
           cnt++;
        }

        return cnt;
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