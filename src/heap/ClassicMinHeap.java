/**
 *   _________________________________________
 *  |			|			 |				 |
 *	|	#elems	|	Build	 |	ExtractMin	 |
 *  |___________|____________|_______________|
 *  |			|			 |				 |
 * 	|	10000	| 00:00:00.2 |   00:00:00.2  |
 * 	|	20000  	| 00:00:00.5 |   00:00:00.2  |
 * 	|	40000  	| 00:00:00.11 |   00:00:00.4  |
 * 	|	80000  	| 00:00:00.2 |   00:00:00.2  |
 * 	|	160000 	| 00:00:00.2 |   00:00:00.2  |
 * 	|	320000 	| 00:00:00.2 |   00:00:00.2  |
 * 	|	640000 	| 00:00:00.2 |   00:00:00.2  |
 * 	|	1280000	| 00:00:00.2 |   00:00:00.2  |
 * 	|	2560000	| 00:00:00.2 |   00:00:00.2  |
 * 	|	5120000	| 00:00:00.2 |   00:00:00.2  |
 * 	|___________|____________|_______________|
 *	|			|			 |				 |
 *	|Efficiency |     O(n)   |      O(n)     |
 *  |___________|_____ ______|_______________|
 * 					
 */

package heap;

import java.util.List;

public class ClassicMinHeap<T> implements MinHeap<T> {

    protected HeapNode<T>[] _heap;
    protected int _size;

    public ClassicMinHeap() {
        init(DEFAULT_SIZE);
    }

    public void build(List<Double> keys, List<T> values) {
        init(keys.size());

        for (int i = 0; i < keys.size(); i++) 
        {
            insert(keys.get(i), values.get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
	private void init(int size) {
        _heap = new HeapNode[size + 1];
        _heap[0] = new HeapNode<T>(-1 * (Integer.MAX_VALUE), null);
        _size = 0;
    }

    public void insert(double key, T value) {
        if (_size == _heap.length - 1) {throw new RuntimeException("Heap is full.");}
        
        _size++;
        
        _heap[_size] = new HeapNode<T>(key, value);
        swim(_size);
    }

    public HeapNode<T> extractMin() {
        if (_size == 0) {throw new RuntimeException("Heap is empty.");}
        
        HeapNode<T> min = _heap[1];
        swap(1, _size);
        _size--;
        sink(1);
        return min;
    }

    public HeapNode<T> peekMin() {
        if (_size == 0) {throw new RuntimeException("Heap is empty.");}
        
        return _heap[1];
    }

    @SuppressWarnings("unchecked")
	public void clear() {
        _size = 0;
        _heap = new HeapNode[DEFAULT_SIZE];
        _heap[0] = new HeapNode<T>(-1 * (Integer.MAX_VALUE), null);
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) 
        {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= _size) {
            int j = 2 * k;
            
            if (j < _size && greater(j, j + 1)) {j++;}
            
            if (!greater(k, j)) {break;}
            
            swap(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return _heap[i]._key > _heap[j]._key;
    }

    private void swap(int i, int j) {
        HeapNode<T> temp = _heap[i];
        _heap[i] = _heap[j];
        _heap[j] = temp;
    }
    
    public boolean isEmpty() {return _size == 0;}

    public int size() {return _size;}

}
