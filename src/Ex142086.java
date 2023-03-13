import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Ex142086 {
    public static void main(String[] args) throws Exception {
        String s = "banana"; // b  a  n  a  n a
        int [] answer = {}; // 0, 1, 2   3  4 5

        answer = new int[s.length()];

        String t[] = s.split("");
        for(int i = 0;i<t.length;i++){
            String w = t[i];
            int idx = -1;
            String temp =  s.substring(0, i);
            for(int j = 0;j<temp.length(); j++){
                if( i != j && w.equals(String.valueOf(temp.charAt(j)) )){
                    idx = j;
                    break;
                }
            }
            System.out.println(w +"=>" +idx);
            answer[i] = idx;
        }








    /*    String temp = "";
        String t[] = s.split("");
        for(int i = 0;i<s.length();i++){
            int index =  temp.indexOf(t[i]);
        *//*    while(index >= 0){
                index = temp.indexOf(t[i]);
            }*//*

          //  if(index == -1){ //없으면
                temp += t[i];
         //   }
            System.out.println(i +"=>"+index);
            answer[i] = index != -1 ? index: -1;
        }*/


        System.out.println(Arrays.toString(answer));
    }
}
