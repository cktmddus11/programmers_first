package ex1845;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Solution1 {
    public int solution(int[] nums) {
        int answer = 0;

        // ex1) hashSet에 담아서 중복을 제거한 후 set의 size를 리턴
        //Map<Integer, Integer> map = new HashMap(); // 1번 포켓몬이 몇마리 존재하는지
        HashSet set = (HashSet) Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // ex1 -1 ) 동일
        //int count2 = new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList())).size();
        // ex2) Integer stream 으로 만든 후 중복제거(distinct) 후 count
        //int count = (int) Arrays.stream(nums).boxed().distinct().count();
        int pokemonCnt = nums.length / 2;
        answer  = pokemonCnt >= set.size() ? set.size() : pokemonCnt;
        //answer = Math.min(set.size(), pokemonCnt);

        return answer;
    }
}