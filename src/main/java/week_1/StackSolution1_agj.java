package week_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackSolution1_agj {


    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList();
        List<Integer> list0 = new ArrayList();
        Queue<Integer> queue = new LinkedList();

        for(int i =0; i < progresses.length; i++){
            int a = 100 - progresses[i];
            double b = (double) a / (double) speeds[i];
            int c = (int)Math.ceil(b);
            list.add(c);
        }

        for (Integer tmp : list) {

            if(queue.peek() == null){
                queue.add(tmp);
                continue;
            }

            if(queue.peek() >= tmp){
                queue.add(tmp);
            }else{
                list0.add(queue.size());
                queue.clear();
                queue.add(tmp);
            }

        }
        list0.add(queue.size());

        answer = new int [list0.size()];

        for(int i = 0; i<list0.size(); i++){
            answer[i] = list0.get(i);
        }
        return answer;

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
