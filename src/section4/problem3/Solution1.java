package section4.problem3;

import java.util.*;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution1 {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String s = scan.next();

        int answer = solution(str, s);
        System.out.println(answer);
    }
//    bacaAacba
//            abc

    private static int solution (String str, String s) {

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }



        return 0;
    }
}

