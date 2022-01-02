package week_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HashSolution1_psw {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> participants = Arrays.stream(participant).sorted().collect(Collectors.toList());
        List<String> completions = Arrays.stream(completion).sorted().collect(Collectors.toList());
        int size = participants.size();
        answer = participants.get(size - 1);
        for (int i = 0; i < size - 1; i++) {
            String ptpt = participants.get(i);
            if (!ptpt.equals(completions.get(i))) {
                answer = ptpt;
                break;
            }
        }
        return answer;
    }



    public static void main(String[] args) {

        String pat[] = {"jsp", "agj", "psw"};
        String com[] = {"agj", "psw"};

        HashSolution1_psw solution = new HashSolution1_psw();
        String answer = solution.solution(pat, com);

        System.out.println(answer);
    }

}
