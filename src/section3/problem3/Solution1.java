package section3.problem3;

import java.util.Scanner;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution1 {
    public static void main(String[] args ){
        Scanner scan = new Scanner(System.in);
      /*  int n = scan.nextInt();
        int m = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }
        int answer = solution(n, m, arr);*/
        int n = 14;
        int m = 2;

        int arr[];
        arr = new int[]{1, 1 ,0 ,0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        int answer = solution(n, m, arr);

        System.out.println(answer);
    }

    private static int solution (int n, int k, int[] arr) {
        int answer = 0;
        int len = 0;
        int lt = 0;
        int cnt = 0;

        for(int rt = 0;rt < n;rt++){
            while(cnt < k){
                if(arr[lt] == 0 ){
                    arr[lt] = 1;
                    cnt++;
                }
                lt++;
            }
            if (arr[rt] != 0){ // 1 일때까지 길이 증감
                int temp = lt - rt + 1;
                if(len <= temp){
                    len = temp;
                }
            }else{ // 0
                cnt = 0;
                rt = lt;

            }
        }
        answer = len;

        return answer;
    }
}
