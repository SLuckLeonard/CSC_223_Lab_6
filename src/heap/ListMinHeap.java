/**
 *   __________________________________________
 *  |			|			   |			   |
 *	|	#elems	|	Build	   |	ExtractMin |
 *  |___________|______________|_______________|
 *  |			|			   |			   |
 * 	|	10000	| 00:00:00.3   |   00:00:00.2  |
 * 	|	20000  	| 00:00:00.4   |   00:00:00.1  |
 * 	|	40000  	| 00:00:00.8   |   00:00:00.2  |
 * 	|	80000  	| 00:00:00.14  |   00:00:00.2  |
 * 	|	160000 	| 00:00:00.8   |   00:00:00.1  |
 * 	|	320000 	| 00:00:00.25  |   00:00:00.3  |
 * 	|	640000 	| 00:00:00.65  |   00:00:00.2  |
 * 	|	1280000	| 00:00:00.115 |   00:00:00.12 |
 * 	|	2560000	| 00:00:00.395 |   00:00:00.34 |
 * 	|	5120000	| 00:00:00.448 |   00:00:00.75 |
 * 	|___________|______________|_______________|
 *	|			|			   |			   |
 *	|Efficiency |     O(n)     |      O(n)     |
 *  |___________|______________|_______________|
 * 					
 *
 * @author <Caden Parry>
 * @date   <03/24/2023>
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
		init(keys.size() + 1);
		for(int i = 0; i < keys.size(); i++)
		{
			insert(keys.get(i), values.get(i));
		}
	}

	@Override
	public void insert(double key, T value) {
		_heap[_size++] = new HeapNode<T>(key, value);

	}

	@Override
	public HeapNode<T> extractMin() {
		if(isEmpty()) return null;

		int indexOfMin = indexOfMin();
		if(indexOfMin < 0) return null;
		
		HeapNode<T> minNode = _heap[indexOfMin];
		shift(indexOfMin);
		_size--;
		
		return minNode;
	}

	@Override
	public HeapNode<T> peekMin() {
		int indexOfMin = indexOfMin();
		if(indexOfMin < 0) return null;
		
		return _heap[indexOfMin];
	}

	private int indexOfMin()
	{
		if(isEmpty()) return -1; 
		
		HeapNode<T> min = _heap[0];
		int index = 0;
		
		for(int i = 0; i < _size; i++)
		{
			HeapNode<T> cur = _heap[i];
			if(min.compareTo(cur) > 0)
			{
				min = cur;
				index = i;
			}
		}
		return index;
	}

	private void shift(int from)
	{
		for (; from < _size - 1; from++)
		{
			_heap[from] = _heap[from + 1];
		}
		
		// the one time that i try to use recursion
//		if(from == _size - 1) return;
//		_heap[from] = _heap[from + 1];
//		shift(from + 1);
	}

	public String toString()
	{
		String string = "";

		string = string + "(";
		for(int i = 0; i < _size; i++)
		{	
			string += (_heap[i]._key);
			string += ", ";
			string += (_heap[i]._value);
			string += ", ";
		}
		if(string.length() > 2) string = string.substring(0, string.length() - 2);

		string = string + ")";

		return string;
	}
}