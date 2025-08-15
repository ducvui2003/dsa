package dataStructure;

import java.util.ArrayList;

class LinkedList {
    ArrayList<Integer> arr;

    public LinkedList() {
        this.arr = new ArrayList<>();
    }

    public int get(int index) {
        try {
            return this.arr.get(index);
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    public void insertHead(int val) {
        this.arr.add(0, val);
    }

    public void insertTail(int val) {
        this.arr.add(val);
    }

    public boolean remove(int index) {
        try {
            this.arr.remove(index);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public ArrayList<Integer> getValues() {
        return this.arr;
    }

    public static void main(String[] args) {
//        ["insertHead", 1, "insertTail", 2, "insertHead", 0, "remove", 1, "getValues"
        LinkedList list = new LinkedList();
        list.insertHead(1);
        list.insertTail(2);
        list.insertHead(0);
        list.remove(1);
        System.out.println(list.getValues());
    }
}