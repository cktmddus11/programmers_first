package section5;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution1 {
    public static void main (String[] args) {
        int n = 8;
        int k = 3;

        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int popIdxArr[] = new int[n - 1];
        popIdxArr[0] = k;
        int temp [] = { 6, 1, 5, 2, 8, 4 };


        for(int i = 0;i<temp.length;i++){
            popIdxArr[i+1] = temp[i];
        }
        System.out.println(Arrays.toString(popIdxArr));


        for (int i = 0; i < popIdxArr.length; i++) {
            stack.push(popIdxArr[i]);
        }
        while (stack.isEmpty()) {
            for (int i = 1; i <= n; i++) {
                if (stack.peek() == i) {
                    stack.pop();
                }
            }
        }

        answer = stack.peek();
        System.out.println(answer);
    }
}
