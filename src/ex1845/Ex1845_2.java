package ex1845;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex1845_2 {
    public static void main(String[] args) {
        /*  int nums[] = {3,1,2,3};*/

        /*  int nums[] = {   3,3,3,2,2,4};*/

        int nums[] = {    3,3,3,2,2,2};



        System.out.println(solution(nums));
    }

    public static int solution(int []nums) {
        int answer = 0;

        //Set<Integer> pokemonSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> pokemonSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        answer = Math.min(pokemonSet.size(), nums.length / 2);


        return answer;
    }
}
