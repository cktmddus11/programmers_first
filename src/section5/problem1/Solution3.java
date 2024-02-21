package section5.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution3 {
    public static void main (String[] args) {
        //        Scanner scanner = new Scanner(System.in);
        //        String str = scanner.next();

        int n = 5;
        int boards[][] = new int[][]{
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 3 },
                { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 }
        }; // TODO  n 길이 초기화
        int m = 8;
        int moves[] = new int[]{ 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println(solution(n, boards, m, moves));
    }

    private static int solution (int n, int[][] boards, int m, int[] moves) {
        int answer = 0;

        // ============== 1. 보드 스택에 담기 ===
        List<Stack> boardList = new ArrayList<>();
        for(int i = 0;i< boards.length;i++){
            Stack<Integer> temp = new Stack<>();
            for(int j = 0;j<boards[i].length;j++){
                temp.push(boards[i][j]);
            }
            boardList.add(temp);
        }

        // ============== 2. 리스트 요소 접근해서 스택에서 pop
        Stack<Integer> basket = new Stack<>();

        for(int i = 0;i<moves.length;i++){
            int move = moves[i];
            Stack<Integer> stack = boardList.get(move);
            Integer doll = stack.pop();
            if(basket.isEmpty()){
                stack.push(doll);
            }else{
                if(basket.peek() == doll){
                    basket.pop();
                    answer++;
                }else{
                    basket.push(doll);
                }
            }
        }

       return answer;
    }


}
