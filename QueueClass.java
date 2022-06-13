import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;


public class QueueClass<T> implements QueueInterface<T> {

	Queue<T> myQ = new LinkedList<>();
	

	
	public QueueClass<T> copy(QueueClass<T> q){
		QueueClass<T> copy = new QueueClass<T>();
		
		Iterator<T> it = q.iterator();
		while (it.hasNext()) {
			copy.enqueue(it.next());
		}
		return copy;
	}
	
	public QueueClass(){
		myQ = new LinkedList<>();
		}
	
	
	@Override
	public void enqueue(T entry) {
		// TODO Auto-generated method stub
		myQ.add(entry);
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return myQ.remove();
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return myQ.peek();
	}

	@Override
	public boolean isEmpty() {
		return myQ.isEmpty();
		
	}

	@Override
	public void clear() {
		myQ.clear();
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < myQ.size();
			}

			@Override
			public T next() {
				if (hasNext()) return myQ.remove();
				throw new RuntimeException("No more");
			}
		};
		
	}
}


