package week_1;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StackSolution1_psw {

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
        par.forEach((key, value) -> {
            result.set(key);
        });
        return result.get();
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        StackSolution1_agj stackSolution1 = new StackSolution1_agj();
        int[] answer = stackSolution1.solution(progresses, speeds);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
