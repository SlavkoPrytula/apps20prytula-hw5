package ua.edu.ucu.itterator;


import java.util.LinkedList;

public class IntIterator implements Iterator<Integer> {
    LinkedList<Integer> list;

    public IntIterator(LinkedList<Integer> l) {
        this.list = l;
    }

    public Integer next() {
        return list.removeFirst();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
