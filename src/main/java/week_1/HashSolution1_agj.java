package week_1;

import java.util.HashMap;

public class HashSolution1_agj {
    public String solution(String[] participant, String[] completion){

        String answer = "err";
        HashMap<String, Integer> hash = new HashMap<>();
        for (String tmp : completion) {
            if (hash.get(tmp) == null) {
                hash.put(tmp, 1);
            } else {
                Integer integer = hash.get(tmp);
                hash.put(tmp, ++integer);
            }
        }

        for (String tmp : participant) {

            if (hash.get(tmp) == null || hash.get(tmp) == 0) {
                return tmp;
            }

            if (hash.get(tmp) > 0) {
                Integer integer = hash.get(tmp);
                hash.put(tmp, --integer);
            }

            return answer;
        }



        return answer;
    }

    public static void main(String[] args) {

        String pat[] = {"jsp", "agj", "psw"};
        String com[] = {"agj", "psw"};

        HashSolution1_agj solution = new HashSolution1_agj();
        String answer = solution.solution(pat, com);

        System.out.println(answer);
    }

}
