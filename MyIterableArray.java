//MyIterableArray.java
// modification of the original MyArray.java from the CS445 handouts
	// references: http://algs4.cs.princeton.edu/43mst/Queue.java.html
	// + class slides and handouts

import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyIterableArray<T> implements MyIterableInterface<T>  // Parameter passed to the type
{
	private T [] theArray;  // Parameter used for array data

	public MyIterableArray(int size)
	{

		@SuppressWarnings("unchecked")	
		T [] temp = (T []) new Object[size];
		theArray = temp;

	}


	public int length()
	{
		return theArray.length;
	}

	// Standard "get and set" methods to retrieve a value and to
	// assign a value.  Note that they do not check array bounds
	// so if the index is invalid an ArrayIndexOutOfBoundsException
	// will be thrown.
	public T get(int i)
	{
		return theArray[i];
	}

	public void set(int i, T data)
	{
		theArray[i] = data;
	}
	
	public String toString()
	{
		StringBuilder S = new StringBuilder();
		for (int i = 0; i < theArray.length; i++)
		{
			S.append(theArray[i] + "\n");
		}
		return S.toString();
	}

	// new iterator code starts here
	
	public Iterator<T> iterator()
    {
		return new ArrayIterator();
	}

	public Iterator<T> getForwardIterator()  {
        return new ArrayIterator();  
    }	
	
    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<T> {
        private int current;

        public ArrayIterator() {
            current = 0;
        }

        public boolean hasNext()  { return current != theArray.length;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
			int return_ix = current;
            current = ++current;
            return theArray[return_ix];
        }
		
    }
	
	public Iterator<T> getReverseIterator() {
		return new ReverseArrayIterator();
	}
	
	// an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<T> {
        private int current;

        public ReverseArrayIterator() {
            current = theArray.length-1;
        }

        public boolean hasNext()  { return current != -1;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
			int return_ix = current;
            current = --current;
            return theArray[return_ix];
        }
		
    }
	
	
	
}
