package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution7 {
    public static void main (String[] args) {
//        String requireStr = "CBA";
//        String classStr = "CBDAGE"; // TRUE CASE
//        String classStr2 = "CAGB"; // FALSE CASE

        Scanner scan = new Scanner(System.in);
        String requireStr = scan.next();
        String classStr = scan.next();

        String answer = "YES";


        answer = solution(requireStr, classStr, answer);
        System.out.println(answer);


    }

    private static String solution (String requireStr, String classStr, String answer) {
        // 필수과목 큐에 넣. pull 시 우선순위 과목대로 꺼내짐.
        Queue<Character> requireClassQueue = new LinkedList();
        for (char c : requireStr.toCharArray()) {
            requireClassQueue.add(c);
        }
        for (char c : classStr.toCharArray()) {
            if (requireClassQueue.contains(c)) {
                if (requireClassQueue.poll() != c) {
                    answer = "NO";
                    break;
                }
            }
        }

        if (!requireClassQueue.isEmpty()) {
            answer = "NO";
        }
        return answer;
    }
}
