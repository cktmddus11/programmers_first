package section5.problem1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution2 {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
      //  String str = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        System.out.println(solution(str));
    }

    private static String solution (String str) {
        Stack<Character> stack = new Stack<>();
        for(Character c : str.toCharArray()){
            if(c == ')'){
                while(stack.pop() != '(');
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<stack.size();i++){
            sb.append(stack.get(i));
        }

        return sb.toString();
    }

}
