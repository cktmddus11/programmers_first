public class Ex147355 {
    public static void main(String[] args) {
/*
        String t = "3141592"; // 314 141 415 159 592
        String p = "271";
*/

//           String t = "500220839878"; // 314 141 415 159 592
//        String p = "7";
        String t = "14141"; // 14 41 14 41
        String p = "41";


        int answer = 0;

        for(int i = 0;i<t.length() ;i++){
            String temp = "";
            int pLen = p.length();
            if(i+pLen > t.length()){
                break;
            }

           temp =  t.substring(i, i+pLen);
            System.out.println(">>> temp : "+temp);

            if(Long.parseLong(temp) <= Long.parseLong(p)){ // Integer.parseInt runtimeError
                answer += 1;
            }
        }


        System.out.println(answer);
    }
}
