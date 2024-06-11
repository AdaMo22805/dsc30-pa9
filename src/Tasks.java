/*
 * Name: Ada Mo
 * PID: A18114308
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
     * check if duplicates entries exists
     *
     * @param entries an integer array of customer IDs
     * @return true if there are duplicates, else false
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
     * find the middle node of a Singly Linked List
     *
     * @param head the first node of the SLL
     * @return the middle node
     */
    public static String middleNode(Node head) {
        Node middle = head; //pointer to find middle
        Node end = head; //pointer goes to end
        if (head == null) { //return null is SLL is empty
            return null;
        }
        if (head.next == null) { //return head if SLL only has one element
            return head.name;
        }
        while (end.next != null) { //iterate until end point finds end and middle pointer will point to middle
            middle = middle.next; //iterate by 1
            end = end.next.next; //iterate by 2
        }
        return middle.name;
    }

    /**
     * check if a new message can be created from an old message
     *
     * @param newMessage a new string message
     * @param oldMessage an old string message
     * @return true if new message can be constructed from old message, else false
     */
    public static boolean canConstruct(String newMessage, String oldMessage) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        if (newMessage.length() > oldMessage.length()) { //if new longer than old then for sure false
            return false;
        }
        for (int i = 0; i < oldMessage.length(); i++) {
            char currChar = oldMessage.charAt(i);
            if (!hashMap.containsKey(currChar)) { //if char not in hash map yet
                hashMap.put(currChar, 1);
            } else {
                hashMap.put(currChar, hashMap.get(currChar) + 1);
            }
            //add to frequency of char if already in hash map
        }

        for (int j = 0; j < newMessage.length(); j++) {
            char currChar = newMessage.charAt(j);
            if (!hashMap.containsKey(currChar)) { //if char not in old's hash map
                return false;
            } else {
                if (hashMap.get(currChar) > 0) { //if frequency of letter > 0
                    hashMap.put(currChar, hashMap.get(currChar) - 1);
                } else {
                    return false; //if frequency of letter = 0
                }
            }
        }
        return true;
    }

    /**
     * find k most frequent customers
     *
     * @param buyers a string array of all buyers
     * @param k an integer indicating how many most frequent buyers we are looking for
     * @return a string array of k most frequent buyers
     */
    public static String[] frequentCustomers(String[] buyers, int k) {
        String[] kLoyal = new String[k];
        HashMap<String, Integer> customerCount = new HashMap<>();
        for (int i = 0; i < buyers.length; i++) { //assign each customer a frequency count
            String currCustomer = buyers[i];
            if (!customerCount.containsKey(currCustomer)) {
                customerCount.put(currCustomer, 1);
            } else {
                customerCount.put(currCustomer, customerCount.get(currCustomer) + 1);
            }
        }

        for (int j = 0; j < k; j++) { //find max k times
            String loyalCustomer = null;
            int max = 0;
            for (String i : customerCount.keySet()) {
                int currCount = customerCount.get(i);
                if (currCount > max || loyalCustomer == null) {
                    max = currCount;
                    loyalCustomer = i;
                }
            }
            customerCount.put(loyalCustomer, -1); //once largest is found, set frequency to -1 so no longer max frequency
            kLoyal[j] = loyalCustomer;
        }
        return kLoyal;
    }

//    public static void main(String[] args) {
//        int[] entries = {123, 456, 789, 123, 999, 888};
//        System.out.print(raffleChecker(entries));
//        Node panda1 = new Node ("Panda1");
//        Node panda2 = new Node ("Panda2");
//        Node panda3 = new Node ("Panda3");
//        Node panda4 = new Node ("Panda4");
//        Node panda5 = new Node ("Panda5");
//        Node panda6 = new Node ("Panda6");
//        Node panda7 = new Node ("Panda7");
//        Node panda8 = new Node ("Panda8");
//        Node panda9 = new Node ("Panda9");
//        panda1.next = panda2;
//        panda2.next = panda3;
//        panda3.next = panda4;
//        panda4.next = panda5;
//        panda5.next = panda6;
//        panda6.next = panda7;
//        panda7.next = panda8;
//        panda8.next = panda9;
//        System.out.print(middleNode(panda1));
//        System.out.print(canConstruct("PANDAS", "PSAND"));
//        String[] buyers = new String[]{"CustomerB", "CustomerB", "CustomerB", "CustomerA", "CustomerC", "CustomerD", "CustomerA", "CustomerD"};
//        for (int i = 0; i < frequentCustomers(buyers, 3).length; i++) {
//            System.out.println(frequentCustomers(buyers, 3)[i]);
//        }
//    }


}

