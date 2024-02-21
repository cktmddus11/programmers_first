package section6;

import java.util.Arrays;

/**
 * @author sycha
 * @since 1.0
 */
public class problem2 {
    public static void main(String[] args) {
        int n = 6;
        int [] arr = {
                13, 5, 11, 7, 23, 15
        };


        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }


    }
}
