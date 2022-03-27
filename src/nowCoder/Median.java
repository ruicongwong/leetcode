package nowCoder;

import java.util.PriorityQueue;

public class Median {
}

class Solution {
    private  int N = 0;
    PriorityQueue<Integer> right = new PriorityQueue<>();
    PriorityQueue<Integer> left = new PriorityQueue<>();
    public void Insert(Integer num) {
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek() / 1.0;
        }
    }
}