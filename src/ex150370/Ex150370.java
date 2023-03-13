package ex150370;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex150370 {
    public static void main(String[] args) throws Exception {
        int[] answer = {};
       /* String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"}; // 약관의 유효기간
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}; // 수집된 개인정보
        // C>>>3:Thu May 19 00:00:00 KST 2022=>2022.05.19 19일에 유효기간 종료이므로 18일까지만 사용가능 19이부터 만료*/

        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"}; // 약관의 유효기간
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}; // 수집된 개인정보


        Date todayDate = convertStringToDate(today, "yyyy.MM.dd");

        // termsMap : 약관, 약관 유효기간
        Map<String, String> termsMap = Arrays.stream(terms)
                .map(t -> t.split(" "))
                .collect(Collectors.toMap(t -> t[0], t -> t[1]));

        // privaciesMap : 수집일자, 약관
        Map<Integer, List<String>> privaciesMap = IntStream.range(0, privacies.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        i -> Arrays.asList(privacies[i].split(" "))
                ));
        ;
      /*  Map<Date, String> privaciesMap = Arrays.stream(privacies)
                .map(p -> p.split(" "))
                .map(p -> new )
                .collect(Collectors.toMap(p -> convertStringToDate(p[0], "yyyy.MM.dd"), p -> p[1], (p1, p2) -> p1, LinkedHashMap::new));*/

       /* privaciesMap.forEach((date, t) -> {
            String termsActiveDate = termsMap.get(t);
            Date addDate = DateUtils.addMonths(date, Integer.parseInt(termsActiveDate));
            String strAddDate = convertDateToString(addDate, "yyyy.MM.dd");
            System.out.println(t+">>>"+termsActiveDate + ":"+addDate+"=>"+strAddDate);

        });*/
        List<Integer> answerList = new ArrayList<>();
        privaciesMap.forEach((index, list) ->{
            Date termDate = convertStringToDate(list.get(0), "yyyy.MM.dd");
            String term = list.get(1);

            // 유효기간 활성 기간
            String termsActiveDate = termsMap.get(term);

            // Date addDate = DateUtils.addMonths(termDate, Integer.parseInt(termsActiveDate));
            Date addDate = getTermExprDate(termDate, termsActiveDate);
            String strAddDate = convertDateToString(addDate, "yyyy.MM.dd");
            System.out.println(term+">>>"+termsActiveDate +"=>"+strAddDate);

            // 파기 대상
            if(addDate.before(todayDate) ){
                answerList.add( index +1 );
            }

        });
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        // 파기 대상
        System.out.println(Arrays.toString(answer));







    }

    private static Date getTermExprDate(Date termDate, String termsActiveDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(termDate);
        calendar.add(Calendar.MONTH, Integer.parseInt(termsActiveDate));

        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if(monthDays == 30){
            calendar.add(Calendar.DATE, -2);
        }else if(monthDays == 31){
            calendar.add(Calendar.DATE, -3);
        }

        return calendar.getTime();
    }

    private static String convertDateToString(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        String strDate = "";
        strDate = df.format(date);
        return strDate;
    }
    private static Date convertStringToDate(String today, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(today);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
