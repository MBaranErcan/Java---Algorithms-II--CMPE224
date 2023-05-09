//-----------------------------------------------------
// Title: Farmland Bag class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Assignment: 2
// Description: This class is the implementation of the Bag class for the second question.
//-----------------------------------------------------
import java.util.*;

public class Bag<T> implements Iterable<T> {
    private Node first;         // The first node.
    private int size;           // The number of elements in the bag.

    private class Node {        // Node class.
        T item;
        Node next;
    }

    public void add(T item) {   // Method to add an item to the bag.
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Iterator<T> iterator() { // Method to return an iterator over the items in the bag.
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
