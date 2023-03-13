   import java.util.ArrayDeque;
import java.util.Queue;

public class ex159994 {
    public static void main(String[] args) {

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = "";

        Queue<String> cardQueue1 = makeCardQueue(cards1);
        Queue<String> cardQueue2 = makeCardQueue(cards2);

        boolean check = true;
        for(String g : goal){
            String card1 = !cardQueue1.isEmpty() ? cardQueue1.peek() : "";
            String card2 = !cardQueue2.isEmpty() ? cardQueue2.peek() : "";

            if(!card1.isEmpty() && card1.equals(g)){
                cardQueue1.poll();
            }
            else if(!card2.isEmpty() && card2.equals(g)){
                cardQueue2.poll();
            }else{
                check = false;
            }

        }
        System.out.println(check);

        answer = check ? "YES" : "NO";


    }

    private static Queue<String> makeCardQueue(String[] cards) {
        Queue<String> cardQueue = new ArrayDeque<>();
        for(String card : cards){
            cardQueue.add(card);
        }
        return cardQueue;
    }
}
