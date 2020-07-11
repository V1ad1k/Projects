package Exercise4;

public class OneWayCircular<E> implements Cloneable {

    public class Element {
        public Element(E e) {
            this.object = e;
        }

        E object;
        Element next = null;

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }


        public E getObject() {
            return object;
        }
    }

    Element head;

    public boolean addHead(E e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
            head.setNext(head);
        } else {
            Element tail = head;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
        }
        return true;
    }

    public boolean addTail(E e) {
        Element newElem = new Element(e);
        Element tail = head;
        while (tail.getNext() != head) {
            tail = tail.getNext();
        }
        tail.setNext(newElem);
        newElem.setNext(head);
        return true;
    }

    public boolean addAt(E e, int index) {
        Element actElem = head;
        Element newElem = new Element(e);
        for (int i = 0; i < index - 1; i++) {
            actElem = actElem.getNext();
        }
        Element right = actElem.getNext();
        actElem.setNext(newElem);
        newElem.setNext(right);
        return true;
    }

    public boolean remove(E e) {
        Element actElem = head;
        while (actElem.getNext() != null && !(actElem.getNext().getObject().equals(e))) {
            actElem = actElem.getNext();
        }
        if (actElem.getNext() == null) {
            return false;
        }
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    public E find(int index) {
        Element actElem = head;
        for (int i = 0; i < index; i++) {
            actElem = actElem.getNext();
        }
        return actElem.getObject();
    }

    public boolean reverse() {
        if (head == null) return false;
        Element last = head;
        Element cur = head.getNext();
        Element prev = head;
        head = head.getNext();
        while (head != last) {
            head = head.getNext();
            Element temp = cur.getNext();
            temp = prev;
            prev = cur;
            cur = head;
        }
        Element temp = cur.getNext();
        temp = prev;
        head = prev;
        return true;
    }

    public boolean addList(OneWayCircular list) {
        Element thisTail = head;
        Element otherHead = list.head;
        while (thisTail.getNext() != head) {
            thisTail = thisTail.getNext();
        }
        if (otherHead == null) return false;
        thisTail.setNext(otherHead);
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
package ll;

public class TwoWayCircular<E> implements Cloneable {
    private class Element {
        public Element(E e) {
            this.object = e;
        }

        E object;
        Element next = null;
        Element prev = null;

        public Element getNext() {
            return next;
        }

        public Element getPrev() {
            return prev;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public E getObject() {
            return object;
        }
    }

    Element head;

    public boolean add(E e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
            head.setNext(head);
            head.setPrev(head);
        } else {
            Element tail = head.getPrev();
            tail.setNext(newElem);
            newElem.setNext(head);
            newElem.setPrev(tail);
            head.setPrev(newElem);
            head = newElem;
        }
        return true;
    }

    public boolean remove(E e) {
        Element actElem = head;
        while (true) {
            if (actElem.equals(e)) {
                Element left = actElem.getPrev();
                Element right = actElem.getNext();
                left.setNext(right);
                right.setPrev(left);
            }
            actElem = actElem.getNext();
            if (actElem == head) return false;
        }
    }

    public E find(int index) {
        Element actElem = head;
        for (int i = 0; i < index; i++) {
            actElem = actElem.getNext();
        }
        return actElem.getObject();
    }

    public boolean reverse() {
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean addList(TwoWayCircular list) {
        Element thisTail = head.getPrev();
        Element otherHead = list.head;
        Element otherTail = otherHead.getPrev();
        if (otherHead == null) return false;
        thisTail.setNext(otherHead);
        otherHead.setPrev(thisTail);
        otherTail.setNext(head);
        head.setPrev(otherTail);
        return true;
    }
}
package ll;

import Iterators.Student;

import java.util.Vector;

public class Group {
    public Student[] selectGood(OneWayCircular<Student> list, double limit){
        Vector<Student> selected = new Vector<>();
        OneWayCircular.Element actElem = list.head;
        while (actElem.getNext() != list.head){
            Student student = (Student) actElem.getObject();
            if (student.getAvgGrade() >= limit){
                selected.add(student);
            }
        }
        return (Student[]) selected.toArray();
    }

    public void removeBad(OneWayCircular<Student> list, double limit){
        OneWayCircular.Element actElem = list.head;
        while (actElem.getNext() != list.head){
            Student student = (Student) actElem.getObject();
            if (student.getAvgGrade() < limit){
                list.remove(actElem);
            }
        }
    }

    public double avgGrade(OneWayCircular<Student> list){
        int counter = 0;
        double total = 0;
        OneWayCircular.Element actElem = list.head;
        while (actElem.getNext() != list.head){
            Student student = (Student) actElem.getObject();
            total += student.getAvgGrade();
            counter++;
        }
        return total / counter;
    }
}