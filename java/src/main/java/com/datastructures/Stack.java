package com.datastructures;

class Stack {
    static int arr[] = new int[10];
    static int top = -1;
    public static void main(String [] args) throws Exception {
        try {
            for(int i = 0; i < 10; i++ ) {
                push(i);
            }
            System.out.println("Deleted element is :  "+  pop());
            System.out.println("Deleted element is :  " + pop());
            System.out.println("Deleted element is :  " + pop());
            print();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            print();
        }

    }


    public static void print() {
        for( int i = 0; i <= top ; i++ ) {
            System.out.print("["+arr[i] + "]");
        }

    }

    public static void push( final int value ) throws Exception  {

        if ( top < arr.length-1  ) {
            top++;
            arr[top] = value;
        }  else {
            throw new Exception(" Stack is full");
        }
    }

    public static int pop() throws Exception {
        int  val = 0;
        if ( top > -1 ) {
            val = arr[top];
            top--;
        } else {
            throw new Exception("Stack is empty");
        }
        return val;
    }

    public static int size() {
        return top;
    }

}
