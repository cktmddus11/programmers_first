package ex138477;

import java.util.*;
public class Ex138477 {
    public static void main(String[] args){
      /*  int k = 3;
        int []score = {10, 100, 20, 150, 1, 100, 200};*/
          //            0   1    2   3  4  5     6
     /*   int k = 4;
        int []score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};*/

        int k = 3;
        int []score = {2,3, 2, 2};

        System.out.println(Arrays.toString(solution(k, score)));

    }

    // stream으로 최소값 찾는거보다 배열 자체를 오름차순으로 정렬해서 0번째 값만 읽어도됨...;;
    public static int[] solution(int k, int[] score) {
        int[] answer = {};
       // int cnt = 0;
        int day = 1;

        List<Integer> answerList = new ArrayList<>();

        //일자별 명예의 전당 최하위 점수 map
        Map<Integer, List<Integer>> dayMinScoreMap = new HashMap<>();

        for(int cnt = 0; cnt < score.length; cnt ++){ // 점수 개수만큼 반복
            if(cnt == 0){ // 첫번째 점수는 전일자와 비교할 내용이 없으므로
                dayMinScoreMap.put(day, Arrays.asList(score[cnt]));
                answerList.add(score[cnt]);
                continue;
            }
            // 두번째 점수부터 부터 전일자의 명예의 전당 리스트를 복사해온다.
            // 전일자 명예의 전당 리스트 조회.
            List<Integer> yesterdaySingerScoreList = dayMinScoreMap.get(day);
            day++;  // 일차 증감.
            int todayScore = score[cnt];
            // List<Integer> todayScore = (List<Integer>) yesterdayScore.clone(); //error Object 의 protected메서드여서 동일한 클래스 또는 하위클래스에서만 사용가능.
            // List<Integer> todayScore = yesterdayScore.stream().collect(Collectors.toList()); // 아래코드와 동일
            List<Integer> yesterdaySingerScoreCopyList = new ArrayList<>(yesterdaySingerScoreList);

            if(yesterdaySingerScoreCopyList.size() < k){// k일전까지는 모든 출연 가수 점수 명예의 전당에 오름.
                yesterdaySingerScoreCopyList.add(todayScore);
            }else {                                     // k일 지나서부터는 k번째 순위(가장 하위의 점수)는 명예의 전당에서 삭제됨.
                // 전일차의 명예의 전당에서 k번째 순위(최소값) 조회, 명예의 전당 삭제 대상점수
                int minScore = yesterdaySingerScoreCopyList.stream()
                        .mapToInt(s -> s).min().orElseThrow(NoSuchElementException::new);

                // minScore < todayScore 햇더니 테스트 15 안되더니 = 붙이니까 되네...??
                if(minScore <= todayScore){ // 오늘 점수보다 명예의 전당 최하위 점수가 작으면 순위에서 내려가게됨.
                    yesterdaySingerScoreCopyList.stream()
                            .filter(s -> s == minScore)
                            .findFirst()
                            .ifPresent(s -> yesterdaySingerScoreCopyList.set(yesterdaySingerScoreCopyList.indexOf(s), todayScore));

                }
            }
            dayMinScoreMap.put(day, yesterdaySingerScoreCopyList);

            System.out.println(dayMinScoreMap.get(day));


            int todayMinScore = yesterdaySingerScoreCopyList.stream()
                    .mapToInt(s -> s).min().orElseThrow(NoSuchElementException::new);
            answerList.add(todayMinScore);
            System.out.println(day +"일차 >>> "+todayMinScore);
        }

        answer = answerList.stream().mapToInt(a -> a).toArray();

        return answer;
    }


}
