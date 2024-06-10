/*
 * Name: TODO
 * PID: TODO
 */

import java.util.*;

/**
 * TODO
 *
 * @author Ada Mo
 * @since June 9, 2024
 */

public class Tasks {

    /**
     * TODO: Question A
     * @param entries
     * @return
     */
    public static boolean raffleChecker(int[] entries) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < entries.length; i++) {
            if (hashMap.containsKey(entries[i])) {
                return true; // Duplicate found
            }
            hashMap.put(entries[i], true); //if duplicate not found, add to hash map
        }
        return false;
    }

    // List Node class provided for reference
    public static class Node {
        Node next;
        String name;
        public Node(String name) {
            this.name = name;
        }
    }

    /**
     * TODO: Question B
     * @param head
     * @return
     */
    public static String middleNode(Node head) {
        Node curr = head;
        if (!curr.name.enull){
            int size = 1;
        }

        return null;
    }

    /**
     * TODO: Question C
     * @param newMessage
     * @param oldMessage
     * @return
     */
    public static boolean canConstruct(String newMessage, String oldMessage) {
       // TODO
        return false;
    }

    /**TODO:
     * Question D
     * @param buyers
     * @param k
     * @return
     */
    public static String[] frequentCustomers(String[] buyers, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args){
        int[] entries = {123, 456, 789, 123, 999, 888};
        System.out.print(raffleChecker(entries));
    }

}
