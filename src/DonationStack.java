/*
 * Name: Ada Mo
 * PID: A18114308
 */

import java.util.*;

/**
 * Stack Implementation to find the largest donor
 *
 * @author Ada Mo
 * @since June 10, 2024
 */

public class DonationStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    /**
     * constructor
     */
    public DonationStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    /**
     * add element into stack
     * @param val an integer indicating donated value
     */
    public void push(int val) {
        stack.push(val);
        if (stack.size() == 1 || val > maxStack.peek()){ //if first element/new max --> add to maxStack
            maxStack.push(val);
        } else{
            maxStack.push(maxStack.peek());
        }
    }

    /**
     * find the element on top of the stack
     * @return top element in stack
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * remove top element
     * @return top element in stack
     */
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    /**
     * find current max value in stack
     * @return max value in stack
     */
    public int max() {
        return maxStack.peek();
    }

//    public static void main(String[] args){
//        DonationStack stack = new DonationStack();
//        stack.push(5);
//        stack.push(10);
//        stack.push(5);
//        stack.push(20);
//        stack.push(15);
//        System.out.println(stack.max());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.max());
//        stack.push(7);
//        stack.push(8);
//        stack.push(0);
//        stack.push(1);
//        stack.push(8);
//        stack.push(2);
//        stack.push(3);
//        stack.push(10);
//        System.out.println(stack.max()); //10
//        System.out.println(stack.pop()); //10
//        System.out.println(stack.max()); //8
//        System.out.println(stack.pop()); //3
//        System.out.println(stack.max()); //8
//        System.out.println(stack.pop()); //2
//        System.out.println(stack.max()); //8
//        System.out.println(stack.pop()); //8
//        System.out.println(stack.max()); //8
//    }
}