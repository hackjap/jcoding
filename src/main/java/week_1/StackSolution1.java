package week_1;

import java.util.ArrayList;

/**
 *
 * 프로그래머스 : 기능개발
 * @author spjang
 * @since 22.01.01 Sat 23:30
 */

public class StackSolution1 {

    /**
     *
     * @param progresses : int[] 진행률
     * @param speeds : int[] 진행속도
     * @return answer : 각 배포마다 배포되는 기능의 수
     *
     * Math.ceil : 소수점 이하 올림
     * list.stream().mapToInt(Integer::intValue).toArray() : List<Interger> -> int[]
     */


    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int[] days = new int[progresses.length];


        /* 어떤게 더 효율적인지?
        int index = 0;
        for (int day : days) {
            days[index] = (int) Math.ceil( (100F - progresses[index]) / speeds[index]);
            index++;
        }
        */

        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil( (100F - progresses[i]) / speeds[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int count = 1;  // 배포되는 기능의 수
        int target = days[0];  // 배포되는 기능


        for (int i = 1; i < days.length; i++) {


            if (target < days[i]) { // 앞에 기능의 진도가 빠를 때
                target = days[i];
                list.add(count);
                count = 1;
            } else {                // 뒤에 기능의 진도가 더 빠를 때
                count++;
            }
        }

        list.add(count);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        StackSolution1 stackSolution1 = new StackSolution1();
        int[] answer = stackSolution1.solution(progresses, speeds);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
