package section5.problem5;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author sycha
 * @since 1.0
 *
 * 처음 괄호는 의미없음 막대기 없으니까
 *
 * 여는괄호 => push
 * 닫는괄호 => 바로 앞의 인덱스를 확인해서 여는 괄호이면 레이저 역할
 * 			=> pop          >> stack에 있는 괄호는 막대기의 개수
 * 		아니면 그냥 막대기 끝
 * 			=> pop 후
 * 			=> 막대기의 끝이므로 +1
 *
 *
 *
 *
 */
public class Solution1 {
    public static void main(String[] args){
       // String str = "(((()(()()))(())()))(()())";

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        int answer = solution(str);
        System.out.println(answer);

    }

    private static int solution (String str) {
        Stack<Character> stack = new Stack<>();

        char[] arr = str.toCharArray();
        int answer = 0;

        for(int i = 0;i<arr.length;i++){
            char c = arr[i];
            if(c == '('){
                stack.push('(');
            }else {
                char frontValue = arr[i-1];
                if(frontValue == '('){ // 레이저부분
                    stack.pop();
                    answer += stack.size();
                }else{ //
                    stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
