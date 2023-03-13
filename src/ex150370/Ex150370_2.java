package ex150370;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex150370_2 {
    //https://umanking.github.io/2020/05/09/java-date-time/
    public static void main(String[] args) throws Exception {
        int[] answer = {};
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"}; // 약관의 유효기간
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}; // 수집된 개인정보
        // C>>>3:Thu May 19 00:00:00 KST 2022=>2022.05.19 19일에 유효기간 종료이므로 18일까지만 사용가능 19이부터 만료

     /*   String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"}; // 약관의 유효기간
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}; // 수집된 개인정보*/


        LocalDate todayDate = convertStringToDate(today, "yyyy.MM.dd");

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


        List<Integer> answerList = new ArrayList<>();
        privaciesMap.forEach((index, list) ->{
            LocalDate termDate = convertStringToDate(list.get(0), "yyyy.MM.dd");
            String term = list.get(1);

            // 유효기간 활성 기간
            String termsActiveDate = termsMap.get(term);

            LocalDate addDate = getTermExprDate(termDate, termsActiveDate);
            String strAddDate = convertDateToString(addDate, "yyyy.MM.dd");
            System.out.println(term+">>>"+termsActiveDate +"=>"+strAddDate);

            // 파기 대상
            if(addDate.isBefore(todayDate) || addDate.equals(todayDate)){
                answerList.add( index +1 );
            }

        });
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(answer));
    }

    private static LocalDate getTermExprDate(LocalDate termDate, String termsActiveDate) {
        LocalDate addDate = termDate.plusDays(Integer.parseInt(termsActiveDate)*28);
        LocalDate lastDay = addDate.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay;
    }

    private static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String strDate = "";
        strDate = date.format(formatter);
        return strDate;
    }
    private static LocalDate convertStringToDate(String today, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate date = null;
        date = LocalDate.parse(today, formatter);
        return date;
    }
}
