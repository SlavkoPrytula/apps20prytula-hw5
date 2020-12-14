package ua.edu.ucu.item;

import ua.edu.ucu.itterator.Iterator;
import ua.edu.ucu.itterator.IntIterator;

import java.util.LinkedList;

public class IntCollection implements Collection {
     LinkedList<Integer> list;

    public IntCollection(LinkedList<Integer> l) {
        this.list = l;
    }

    public Iterator<Integer> createIterator() {
        return new IntIterator(list);
    }
}
