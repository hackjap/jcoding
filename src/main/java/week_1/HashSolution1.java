package week_1;

import java.util.HashMap;

/**
 * 프로그래머스 : 완주하지 못한 선수
 * @author spjang
 * @since 22.01.01 Sat 23:10
 */

public class HashSolution1 {
    public String solution(String[] participant, String[] completion){

        /**
         * @param participant : String[] 참여한 선수
         * @param completion : String[] 완주한 선수
         *
         * @return answer : String 완주하지 못한 선수 이름
         *
         * getOrDefault() : 찾는 키가 존재하면 해당 키의 값을 반환하고 없으면 기본 값을 반환
         */

        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String pat[] = {"jsp", "agj", "psw"};
        String com[] = {"agj", "psw"};

        HashSolution1 solution = new HashSolution1();
        String answer = solution.solution(pat, com);

        System.out.println(answer);
    }

}
