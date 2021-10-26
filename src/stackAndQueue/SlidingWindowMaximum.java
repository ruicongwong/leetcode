package stackAndQueue;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 优先队列
        // 维护一个优先队列，优先队列里面存一个元组（值，下标）,初始化时先将k个元组放入
        // 优先队列（大根堆）中，然后从k+1个元素开始继续向优先队列中添加元组，每添加一次，就将下标不在
        // 窗口中的元组移除
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]));
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while(pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = nums[pq.peek()[1]];
        }
        return ans;
    }
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        // 单调队列
        // 队列中维护窗口中元素大小单调递减的下标
        int n = nums.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
