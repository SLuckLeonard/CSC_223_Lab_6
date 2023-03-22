/**
 * Write a succinct, meaningful description of the class here. You should avoid wordiness    
 * and redundancy. If necessary, additional paragraphs should be preceded by <p>,
 * the html tag for a new paragraph.
 *
 * <p>Bugs: (a list of bugs and / or other problems)
 *
 * @author <your name>
 * @date   <date of completion>
 */

package heap;

import java.util.List;


public class ListMinHeap<T> implements MinHeap<T>
{
	protected HeapNode<T>[] _heap;
	protected int           _size;

	public ListMinHeap(int sz)
	{
		init(sz);
	}

	public ListMinHeap() { this(DEFAULT_SIZE); }

	@SuppressWarnings("unchecked")
	protected void init(int sz)
	{
		_heap = (HeapNode<T>[]) new HeapNode[sz];
		_size = 0;
	}

	public void clear() { init(_heap.length); }
	public boolean isEmpty() { return _size == 0; }
	public int size() { return _size; }

	@Override
	public void build(List<Double> keys, List<T> values) {
		
		init(keys.size());
		for(int i = 0; i < keys.size(); i++) {
			insert(keys.get(i), values.get(i));
		}
	}

	@Override
	public void insert(double key, T value) {

		_heap[_size + 1] = new HeapNode<T>(key, value); 
		
		_size++;

	}

	@Override
	public HeapNode<T> extractMin() {

		if(!isEmpty()) {

			HeapNode<T> min = _heap[1];
			
			int index = 0;
			
			// find the minimum and its index
			for(int i = 0; i <= _size; i++) {

				if(min.compareTo(_heap[i]) > 0) {
					
					min = _heap[i];
					
					index = i;
				}
				
			}
			
			// slide everything down 1 from where the minimum was on to the end
			for(int i = index; i < _size; i++) { _heap[i] = _heap[i + 1]; }
			
			_heap[_size] = null;
			
			_size--;
			
			return min;
		}

		return null;
	}

	@Override
	public HeapNode<T> peekMin() {
		
		if(!isEmpty()) {

			HeapNode<T> min = _heap[1];
			
			// find the minimum
			for(int i = 0; i <= _size; i++) {

				if(min.compareTo(_heap[i]) > 0) {
					
					min = _heap[i];	
				}	
			}
			return min;
		}

		return null;
	}

}