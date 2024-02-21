package section6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sycha
 * @since 1.0
 *
 * 선택 정렬(Selection Sort)
 * 주어진 리스트에서 가장 작은 원소를 찾아 맨 앞으로 이동시키는 과정을 반복하여 정렬을
 *
 *
 * 리스트의 첫 번째 원소를 기준으로 선택합니다.
 * 나머지 원소들과 비교하여 가장 작은 원소를 찾습니다.
 * 가장 작은 원소와 기준 원소의 위치를 교환합니다.
 * 다음 위치를 기준으로 선택하고 위의 과정을 반복합니다.
 *
 */
public class problem1 {
    public static void main(String[] args){
        /*int n = 5;
        int [] arr = {
                13, 5, 11, 7, 23, 15
        };*/

        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }

        solution(arr);
        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
     //   System.out.println(Arrays.toString(arr));
    }

    private static void solution (int[] arr) {
        for(int i = 0; i< arr.length; i++){  // 기준 값 위치
            int minIdx = i;
            for(int j = i; j< arr.length; j++){ // 다른 값들을 비교해서
                if(arr[j] < arr[minIdx]){ // 최소값 위치를 찾음.
                    minIdx = j;
                }
            }
            int tmp = arr[i]; // 기준값 임시저장.
            arr[i] =  arr[minIdx]; // 최소값, 기준위치에 저장.
            arr[minIdx] = tmp; // 최소값 위치에 기준값 저장.
        }
    }
}
