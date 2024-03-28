package Linked_List;

import java.util.HashMap;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 */
public class LRUCache {
    /*
Doubly Linked List Definition:
A private nested class DLinkedList is defined to represent nodes in the doubly linked list.
Each node has key, value, pre (previous node reference), and post (next node reference) attributes.
LRUCache Class Attributes:
head and tail are dummy nodes representing the head and tail of the doubly linked list.
count represents the number of elements currently in the cache.
capacity represents the maximum capacity of the cache.
cache is a HashMap that stores the mapping of keys to corresponding DLinkedList nodes.
Helper Methods:
addNode: Adds a node after the head dummy node.
removeNode: Removes a specified node from the linked list.
moveToHead: Moves a node to the head of the linked list.
popTail: Removes and returns the node at the tail of the linked list.
Constructor:
Initializes the cache with the specified capacity.
Initializes count, cache, head, and tail.
Connects head and tail nodes in the linked list.
get Method:
Retrieves the node associated with the given key from the cache.
If the node exists, it moves it to the head of the linked list (since it's the most recently used) and returns its value. Otherwise, returns -1.
put Method:
Adds a new node with the given key and value to the cache.
If the key already exists, it updates the value and moves the node to the head of the linked list.
If the cache exceeds its capacity after insertion, it removes the least recently used node (tail of the linked list).
     */
    private class DLinkedList{
        int key;
        int val;
        DLinkedList pre;
        DLinkedList post;
    }
    private DLinkedList head;
    private DLinkedList tail;
    private int count,capacity;
    private HashMap<Integer,DLinkedList>cache;
    private void addNode(DLinkedList node){
        node.pre=head;
        node.post=head.post;
        head.post.pre=node;
        head.post=node;
    }
    private void removeNode(DLinkedList node){
        DLinkedList pre=node.pre;
        DLinkedList post=node.post;
        pre.post=post;
        post.pre=pre;
    }
    private void moveToHead(DLinkedList node){
        removeNode(node);
        addNode(node);
    }
    private DLinkedList popTail(){
        DLinkedList res = tail.pre;
        this.removeNode(res);
        return res;
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        count=0;
        cache=new HashMap<>();
        head=new DLinkedList();
        head.pre=null;
        tail=new DLinkedList();
        tail.post=null;
        head.post=tail;
        tail.pre=head;
    }
    public int get(int key) {
        DLinkedList node=cache.get(key);
        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.val;
        }
    }
    public void put(int key, int value) {
        DLinkedList node= cache.get(key);
        if(node==null){
            node=new DLinkedList();
            node.key=key;
            node.val=value;
            addNode(node);
            cache.put(key,node);
            count++;
            if(count>capacity){
                DLinkedList tail=popTail();
                cache.remove(tail.key);
                count--;
            }
        }else{
            node.val=value;
            moveToHead(node);
        }
    }
}