package ex1845;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex1845_3 {
    public static void main(String[] args) {
        /*  int nums[] = {3,1,2,3};*/

        /*  int nums[] = {   3,3,3,2,2,4};*/

        int nums[] = {    3,3,3,2,2,2};



        System.out.println(solution(nums));
    }

    public static int solution(int []nums) {
        int answer = 0;

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size() , nums.length / 2)));
    }
}
