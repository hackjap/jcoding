package week_1;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StackSolution1_psw {

    public int[] solution(int[] progresses, int[] speeds) {

        int[] ans = null;
        ArrayList<Integer> answer = new ArrayList<>();
        int size = progresses.length;
        Queue<Integer> workingDays = new ConcurrentLinkedQueue<>();
        Integer stdDay = 0;
        int deploys = 1;

        for (int i = 0; i < size; i++) {
            workingDays.add((int) Math.ceil(100 - progresses[i] / (float) speeds[i]));
        }

        stdDay = workingDays.poll();
        while (!workingDays.isEmpty()) {
            Integer compDay = workingDays.poll();
            if (stdDay >= compDay) {
                deploys++;
            }else {
                answer.add(deploys);
                stdDay = compDay;
                deploys = 1;
            }
        }
        answer.add(deploys);

        ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return  ans;
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
