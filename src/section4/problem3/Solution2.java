package section4.problem3;

import java.util.*;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution2 {
    public static void main (String[] args) {
      /*  int n = 7;
        int k = 4;

        int arr[] = new int[n];
        arr = new int[]{ 20, 12, 20, 10, 23, 17, 10 };*/
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int arr[] = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        List<Integer> answer = new ArrayList<>();
        answer = solution(k, arr);

        for(Integer i : answer){
            System.out.print(i+" ");
        }
    }

    private static List<Integer> solution (int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < k - 1; i++) { // k 개만큼이니까  k-1까지 넣고
            tempMap.put(arr[i], tempMap.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < arr.length; rt++) {
            tempMap.put(arr[rt], tempMap.getOrDefault(arr[rt], 0) + 1);  // k 번쨰 넣으면서 k개매출 만족이니까
            answer.add(tempMap.size()); // map 사이즈로 매출액 종료 넣고

            int key = arr[lt++];
            if (tempMap.get(key) > 1) {  // 삭제할 값이 맵에 있으면
                tempMap.put(key, tempMap.get(key) - 1); // map의 개수를 하나 감소
            } else {
                tempMap.remove(key);  //  map에 한개만 있었으면 아에 삭제
            }
        }
        return answer;
    }
}
