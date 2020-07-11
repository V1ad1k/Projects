package queue;
import javax.naming.SizeLimitExceededException;
import java.util.NoSuchElementException;

public class ArrayFifiQueue<E> {
	E element() {
		E obj = (E) array[headpos];
				return obj;
	}
	E peek() {
		if (array[headpos]==null)
			return null;
		return this.element();
	}
	
	private Object array[];
	int size = 0;
    int maxsize =0;
    public ArrayFifiQueue(final int maxsize) {
    	this.maxsize=maxsize;
    	Object array[] = new Object[maxsize];
    }
    	private int headpos=0;
    	int nextpos=0;
    boolean add(E obj) throws SizeLimitExceededException{
    if (size >=maxsize) throw new SizeLimitExceededException();
    array[headpos]=(E) obj;
    size++;
    if(nextpos>=maxsize)
    	nextpos=0;
    return true;
    }
    E remove() throws NoSuchElementException{
    	size--;
    	E get = (E) array[headpos];
    	array[headpos]=null;
    	headpos++;
    	if(headpos>=size) headpos=0;
    	return get;}
 E poll () {
	 E obj = this.peek();
	 if(obj==null)
		 return null;
	 array[headpos]=null;
	 size--;
	 if (headpos>=maxsize)
		 headpos=0;
	 return obj;

 }
 }
    
