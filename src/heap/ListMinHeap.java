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
		int indexOfMin = indexOfMin();
		HeapNode<T> minNode = _heap[indexOfMin];
		shift(indexOfMin);
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
		HeapNode<T> min = _heap[0];
		int index = -1;
		
		for(int i = 0; i < _size; i++)
		{
			HeapNode<T> cur = _heap[i];
			if(min.compareTo(cur) > 0) min = cur;
			index = i;
		}
		return index;
	}
	
	private void shift(int from)
	{
		if(from == _size) return;
		_heap[from] = _heap[++from];
		shift(++from);
	}
}