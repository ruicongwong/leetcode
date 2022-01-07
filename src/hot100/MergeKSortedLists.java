package hot100;

import list.ListNode;

import java.util.List;

public class MergeKSortedLists {
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) return lists[l];
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists,l, mid), merge(lists,mid + 1, r));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (a != null && b != null) {
            if (a.val > b.val) {
                cur.next = b;
                b = b.next;
            } else {
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        }
        if (b != null) {
            cur.next = b;
        }
        return head.next;
    }
}