package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    final LNode head = new LNode();
    final LNode tail = new LNode();
    Map<Integer, LNode> map;
    int cache_capacity;

    public LRUCache(int capacity){
        this.cache_capacity = capacity;
        map = new HashMap<Integer, LNode>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        LNode node = map.get(key);
        int result = -1;

        if(node != null){
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        LNode node = map.get(key);

        if(node != null){
            remove(node);  //removing to add it in front
            node.value = value;
            add(node);
        } else {
            if(map.size() == cache_capacity){ //capacity full, removing last node which is least used
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            LNode newNode = new LNode();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            add(newNode);
        }
    }

    public void add(LNode newNode){
        LNode tempNode = head.next;
        newNode.next = tempNode;
        tempNode.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    public void remove(LNode deleteNode){
        LNode nextNode = deleteNode.next;
        LNode prevNode = deleteNode.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String args[]){
        LRUCache obj = new LRUCache(70);

    }
}

class LNode {
    int key;
    int value;
    LNode prev;
    LNode next;
}
