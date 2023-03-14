package ex1845;

import java.util.Arrays;

public class Ex1845 {
    public static void main(String[] args) {
      /*  int nums[] = {3,1,2,3};*/

      /*  int nums[] = {   3,3,3,2,2,4};*/

        int nums[] = {    3,3,3,2,2,2};



        System.out.println(solution(nums));
    }

    public static int solution(int []nums) {
        int answer = 0;
        int n = nums.length / 2;
        // Hash로 푸는 문제 그중 HashSet을 이용해서 중복요소를 없앨 수 있음.
        int elementCnt = (int) Arrays.stream(nums).distinct().count();
        //answer = elementCnt >= n ? n : elementCnt;
        answer = Math.min(elementCnt, n);

        return answer;
    }
}