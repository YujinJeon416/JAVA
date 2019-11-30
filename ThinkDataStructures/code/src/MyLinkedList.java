//import sun.font.TrueTypeFont;
//
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//
//public class MyLinkedList<E> implements List<E> {
//    private class Node{
//        public E cargo;
//        public Node next;
//
//        public Node(E cargo) {
//            this.cargo = cargo;
//            this.next = null;
//        }
//        public Node(E cargo, Node next) {
//            this.cargo = cargo;
//            this.next = next;
//        }
//
//        public String toString() {
//            return "Node(" + cargo.toString() +")";
//        }
//    }
//
//    private int size;
//    private Node head;
//
//    public MyLinkedList() {
//        head = null;
//        size = 0;
//
//    }
//
//    public static void main(String[] args) {
//    }
//
//
//    @Override
//    public boolean add(E element) {
//        return true;
//    }
//
//    @Override
//    public void add(int index, E element) {
//
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends E> collection)
//
//
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//}
//
//
//


import java.util.ArrayList;

class Product{}
class Tv extends Product{}
class Radio extends Product{}

public class MyLinkedList{

    public static void main(String[] args) {
        ArrayList<? extends Product> list = new ArrayList<Tv>();//허용안함
    }
}