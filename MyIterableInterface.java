// MyIterableInterface.java
// interface to go along with MyIterableArray
import java.util.Iterator;

public interface MyIterableInterface<T> extends Iterable<T>
{
   public Iterator<T> getForwardIterator();
   public Iterator<T> getReverseIterator();
} 