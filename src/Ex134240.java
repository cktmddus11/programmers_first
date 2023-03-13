public class Ex134240 {
    public static void main(String[] args) throws Exception {
        int[] food = {1, 7, 1, 2};
        String answer = "";

        StringBuffer sb = new StringBuffer(answer);
        for(int i = 1;i<food.length;i++){
            for(int j = 0;j<food[i] / 2;j++){
                sb.append(i);
            }
        }
       // System.out.println(sb.toString());
        answer += sb.toString() +"0";

        answer += sb.reverse();

        System.out.println(answer);
    }
}
