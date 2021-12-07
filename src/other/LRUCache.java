package other;


import java.util.HashMap;

public class LRUCache {
    class DLinkedNode{
        DLinkedNode prev;
        DLinkedNode next;
        int key;
        int value;
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public DLinkedNode() {}
    }
    private int capacity;
    private int size;
    private HashMap<Integer, DLinkedNode> cache;
    private DLinkedNode tail, head;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.tail = new DLinkedNode();
        this.head = new DLinkedNode();
        tail.prev = head;
        head.next = tail;
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            cache.put(key, dLinkedNode);
            addToHead(dLinkedNode);
            size++;
            if(size > capacity) {
                DLinkedNode linkedNode = removeTail();
                cache.remove(linkedNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    private DLinkedNode removeTail() {
        DLinkedNode res = this.tail.prev;
        removeNode(res);
        return res;
    }
    private void addToHead(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}