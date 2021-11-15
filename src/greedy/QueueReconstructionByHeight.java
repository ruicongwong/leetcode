package greedy;


import java.util.Arrays;
import java.util.LinkedList;

public class QueueReconstructionByHeight {
}

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1],person);
        }
        return queue.toArray(new int[people.length][]);
    }
}
