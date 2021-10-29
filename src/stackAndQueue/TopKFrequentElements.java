package stackAndQueue;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        System.out.println(Arrays.toString(solution347.topKFrequent_1(new int[]{1, 2}, 2)));
    }
}
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if(queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else{
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
    public int[] topKFrequent_1(int[] nums, int k) {
        // 基于快排
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        help(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    private void help(List<int[]> values, int l, int r, int[] ret, int retIndex, int k) {
        int index = partition(values, l, r);
        if(k <= index - l) {
            help(values, l, index - 1, ret, retIndex, k);
        } else {
            for (int i = l; i <= index ; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if(k > index - l + 1) {
                help(values, index + 1, r, ret, retIndex, k - (index - l + 1));
            }
        }
    }

    private int partition(List<int[]> values, int l, int r) {
        int pivot = values.get(l)[1];
        int i = l;
        int j = r;
        while (i < j){
            while (i < j && values.get(j)[1] <= pivot) j--;
            if(i < j) Collections.swap(values,j ,i);
            while (i < j && values.get(i)[1] >= pivot) i++;
            if(i < j) Collections.swap(values,i ,j);
        }
        return i;
    }

}
