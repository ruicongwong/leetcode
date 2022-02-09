package alibaba;

import list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
}
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null){
                pq.offer(node);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;
            if (poll.next != null) {
                pq.offer(poll.next);
            }
            cur = cur.next;
        }
        return head.next;
    }
}
