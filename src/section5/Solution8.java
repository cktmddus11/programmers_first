package section5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sycha
 * @since 1.0
 */
public class Solution8 {
    public static void main (String[] args) {
        int n = 5;
        int m = 2;
        int arr[] = new int[n];
        arr = new int[]{ 60, 50, 70, 80, 90 };

        int answer = solution(n, m, arr);
        System.out.println(answer);
    }
    public static int solution(int n, int m, int[] arr){
        int answer=0;
        Queue<Person> Q=new LinkedList<>();
        for(int i=0; i<n; i++){
            Q.offer(new Person(i, arr[i]));
        }
        while(!Q.isEmpty()){
            Person tmp=Q.poll();
            System.out.println(Arrays.toString(Q.toArray()));
            for(Person x : Q){
                System.out.println(x.priority +":"+tmp.priority);
                if(x.priority>tmp.priority){
                    Q.offer(tmp);
                    System.out.println("후순위 이동 : "+tmp.toString());

                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m) return answer;
            }
        }
        return answer;
    }
}

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }

    @Override
    public String toString () {
        return "Person{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }
}
