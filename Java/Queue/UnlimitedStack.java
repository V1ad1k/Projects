package queue;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class UnlimitedStack<E> {
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
	public boolean isEmpty() {
		return list.isEmpty();}
	public boolean isFull() {
		return false;}
	public int size() {
		return list.size();
	}
	LinkedList<E> list;
	public UnlimitedStack() {
		list = new LinkedList<E>(); }
			public E pop() throws EmptyStackException {
				E value = list.remove();
				if(value==null) throw new EmptyStackException();
				return value;
			}
			public void push(E elem) {
				list.add(elem);
			}
			public E remove() {
				E toReturn = (E) head;
				head = head.getNext();
				return toReturn;
			}
			public void add(Element elem) {
				elem.setNext(elem);
				head=elem;
			}
		}


