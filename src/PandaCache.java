/*
 * Name: Ada Mo
 * PID: A18114308
 */

import java.util.*;

/**
 * implementation of panda cache
 *
 * @author Ada Mo
 * @since June 10, 2024
 */

public class PandaCache {

    /**
     * class to create panda nodes
     */
    private class pandaNode {
        int pandaID;
        int zoneNumber;
        pandaNode prev;
        pandaNode next;

        /**
         * constructor
         * @param pandaID integer storing panda IDs
         * @param zoneNumber integer storing the zone a panda is in
         */
        protected pandaNode (int pandaID, int zoneNumber) {
            this.pandaID = pandaID;
            this.zoneNumber = zoneNumber;
        }
    }

    private int capacity;
    private int size;
    private HashMap<Integer, pandaNode> pandaNodes;
    private pandaNode head;
    private pandaNode tail;

    /**
     * constructor
     * @param capacity an integer indicating how many panda records can be stored
     */
    public PandaCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.pandaNodes = new HashMap<>();
        this.head = new pandaNode(-1,-1); //dummy head
        this.tail = new pandaNode(-1, -1); //dummy tail
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get zone number of a panda
     * @param pandaID the ID of a panda
     * @return the zone number of a panda if known, else -1
     */
    public int get(int pandaID) {
        if (!pandaNodes.containsKey(pandaID)){
            return -1;
        } else {
            pandaNode curr = pandaNodes.get(pandaID);
            remove(curr); //remove node from DLL
            addToFront(curr); //add to front
            return curr.zoneNumber;
        }
    }

    /**
     * set the zone number of a panda
     * @param pandaID the ID number of a panda
     * @param zoneNumber an integer indicating the zone a panda is in
     */
    public void set(int pandaID, int zoneNumber) {
        if (pandaNodes.containsKey(pandaID)){
            pandaNode curr = pandaNodes.get(pandaID);
            curr.zoneNumber = zoneNumber;
            remove(curr);
            addToFront(curr);
        } else {
            if (size == capacity){
                pandaNode toRemove = tail.prev;
                pandaNodes.remove(toRemove.pandaID); //remove node from hashmap
                remove(toRemove);
                size--;
            }
            pandaNode newPanda = new pandaNode(pandaID, zoneNumber);
            pandaNodes.put(pandaID, newPanda);
            addToFront(newPanda);
            size++;
        }
    }

    private void remove(pandaNode curr){
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
    private void addToFront(pandaNode curr){
        curr.next = head.next;
        head.next.prev = curr;
        head.next = curr;
        curr.prev = head;
    }

//    public static void main(String[] args){
//        PandaCache cache = new PandaCache(3);
//        cache.set(123, 1);
//        cache.set(456, 2);
//        cache.set(789, 1);
//        System.out.println(cache.get(123));
//        cache.set(999, 3);
//        System.out.println(cache.get(456));
//    }
}