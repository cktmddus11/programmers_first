package problem6;

import java.util.Scanner;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution1 {
    public static void  main(String[] args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];

        for(int i = 0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }
        int answerArr[] = solution(n, arr);

        for(int i = 0;i<arr.length;i++){
           System.out.println(arr[i]);
        }


    }

    private static int[] solution (int n, int[] arr) {
        for(int i = 0;i<arr.length;i++){
            int num = arr[i];



            int nmg = 0;
            while(nmg < 10){

            }

        }

        return null;
    }
}
