import java.util.Arrays;

public class ex160586 {
    public static void main(String[] args){
        int[] answer = {};

//        String[] keymap = {"ABACD", "BCEFD"};     A 1 B 3 1
//        String[] targets = {"ABCD","AABB"};

//        String[] keymap = {"AA"};
//        String[] targets = {"B"};

        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA", "BGZ"};

        answer = new int[targets.length];


        for(int x = 0; x < targets.length; x++){
            String[] temp = targets[x].split("");
            // A B C D
            int cnt = 0;
            for(int i = 0; i < temp.length; i++){
                int index = 0;

                for(String key : keymap){
                    int j = key.indexOf(temp[i]);
                    if(index != -1 && j != -1){
                        index = Math.min(index, j+1);
                    }else if(index == -1 ){
                        index = j+1;
                    }
                }
                cnt += index;//(index != 0 ? index  : -1);
                System.out.println(temp[i] +":"+cnt);
            }
            answer[x] = cnt;
        }



        System.out.println(Arrays.toString(answer));
    }
}
