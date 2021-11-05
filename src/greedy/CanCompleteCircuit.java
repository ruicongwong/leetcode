package greedy;

import java.util.stream.IntStream;

public class CanCompleteCircuit {
}


class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = IntStream.of(gas).sum();
        int costSum = IntStream.of(cost).sum();
        if (costSum > gasSum) return -1;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}