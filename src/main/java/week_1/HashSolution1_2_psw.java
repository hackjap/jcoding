package week_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class HashSolution1_2_psw {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> par = new HashMap<>();
        for (String p : participant) {
            par.put(p, par.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            par.put(c, par.get(c) - 1);
            if (par.get(c) == 0) {
                par.remove(c);
            }
        }
        AtomicReference<String> result = new AtomicReference<>();
        par.forEach((key,value)-> {
            result.set(key);
        });
        return result.get();
    }



    public static void main(String[] args) {

        String pat[] = {"jsp", "agj", "psw"};
        String com[] = {"agj", "psw"};

        HashSolution1_2_psw solution = new HashSolution1_2_psw();
        String answer = solution.solution(pat, com);

        System.out.println(answer);
    }

}
