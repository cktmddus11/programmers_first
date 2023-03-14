package ex12906;

import java.util.Arrays;
import java.util.Stack;

public class Ex12906 {
    public static void main(String[] args) {
        /*  int nums[] = {3,1,2,3};*/

        /*  int nums[] = {   3,3,3,2,2,4};*/

        int arr[] = { 1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int []arr) {

        Stack<Integer>  stack = new Stack<>();
      //  for(int i = 0;i<nums.length;i++){
        for(int a : arr) {
            if(stack.isEmpty()){
                stack.add(a);
                continue;
            }

            if(stack.peek() == a){
                continue;
            }

            stack.add(a);
        }
        return stack.stream().mapToInt(i -> i).toArray();



     /*   return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet()
                        , n -> n.stream().mapToInt(Integer::intValue))).toArray();*/
    }
}
