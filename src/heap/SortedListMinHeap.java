/**
 *   _________________________________________
 *  |			|			 |				 |
 *	|	#elems	|	Build	 |	ExtractMin	 |
 *  |___________|____________|_______________|
 *  |			|			 |				 |
 * 	|	10000	| 00:00:00.10|   00:00:00.0  |
 * 	|	20000  	| 00:00:00.10|   00:00:00.1  |
 * 	|	40000  	| 00:00:00.25|   00:00:00.1  |
 * 	|	80000  	| 00:00:00.85|   00:00:00.3  |
 * 	|	160000 	|00:00:00.108|   00:00:00.2  |
 * 	|	320000 	|00:00:00.169|   00:00:00.3  |
 * 	|	640000 	|00:00:00.281|   00:00:00.8  |
 * 	|	1280000	|00:00:00.582|  00:00:00.16  |
 * 	|	2560000	|00:00:02.415|  00:00:00.31  |
 * 	|	5120000	|00:00:03.793|  00:00:00.56  |
 * 	|___________|____________|_______________|
 *	|			|			 |				 |
 *	|Efficiency |     O(n)   |      O(n)     |
 *  |___________|_____ ______|_______________|
 * 		
 *  This class constructs a min heap as a sorted array
 * <Bugs> None have been detected
 * @author <Sam Luck-Leonard>
 * @date <03-24-23>
 * 				
 */			
 

package heap;

import java.util.Arrays;
import java.util.List;

public class SortedListMinHeap<T extends Comparable<T>> implements MinHeap<T> {

    protected HeapNode<T>[] _heap;
    protected int _size;

    public SortedListMinHeap() {
        this(ListMinHeap.DEFAULT_SIZE);
    }

    public SortedListMinHeap(int sz) {
        init(sz);
    }

    @SuppressWarnings("unchecked")
    protected void init(int sz) {
        _heap = (HeapNode<T>[]) new HeapNode[sz];
        _size = 0;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void build(List<Double> keys, List<T> values) {
        _size = keys.size();
        _heap = (HeapNode<T>[]) new HeapNode[_size];
        for (int i = 0; i < _size; i++) 
        {
            _heap[i] = new HeapNode<>(keys.get(i), values.get(i));
        }
        Arrays.sort(_heap);
    }

    @Override
    public void insert(double key, T value) {
        int index = _size;
        HeapNode<T> node = new HeapNode<>(key, value);
        while (index > 0 && node.compareTo(_heap[index - 1]) < 0) 
        {
            _heap[index] = _heap[index - 1];
            index--;
        }
        _heap[index] = node;
        _size++;
    }

    @Override
    public HeapNode<T> extractMin() {
        if (isEmpty()) {return null;}
        HeapNode<T> minNode = _heap[0];
        for (int i = 1; i < _size; i++) 
        {
            _heap[i - 1] = _heap[i];
        }
        _size--;
        return minNode;
    }

    @Override
    public HeapNode<T> peekMin() {
        if (isEmpty()) {return null;}
        return _heap[0];
    }

    @Override
    public boolean isEmpty() {return _size == 0;}

    @Override
    public int size() {return _size;}

    @Override
    public void clear() {init(_heap.length);}

}
