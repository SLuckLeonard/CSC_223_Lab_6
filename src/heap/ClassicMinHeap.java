/**
 *   _________________________________________
 *  |			|			 |				 |
 *	|	#elems	|	Build	 |	ExtractMin	 |
 *  |___________|____________|_______________|
 *  |			|			 |				 |
 * 	|	10000	| 00:00:00.4 |   00:00:00.0  |
 * 	|	20000  	| 00:00:00.4 |   00:00:00.0  |
 * 	|	40000  	| 00:00:00.7 |   00:00:00.0  |
 * 	|	80000  	| 00:00:00.13|   00:00:00.0  |
 * 	|	160000 	| 00:00:00.25|   00:00:00.0  |
 * 	|	320000 	| 00:00:00.43|   00:00:00.0  |
 * 	|	640000 	| 00:00:00.82|   00:00:00.0  |
 * 	|	1280000	| 00:00:00.90|   00:00:00.0  |
 * 	|	2560000	|00:00:00.318|   00:00:00.0  |
 * 	|	5120000	|00:00:00.716|   00:00:00.0  |
 * 	|___________|____________|_______________|
 *	|			|			 |				 |
 *	|Efficiency |     O(n)   |      O(n)     |
 *  |___________|_____ ______|_______________|
 * 	
 * This class constructs a min heap using an array based implementation
 * <Bugs> None have been detected
 * @author <Mason Taylor>
 * @date <03-24-23>
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

    /*
     * Determines whether the element at index i is greater than the element at index j.
	 * Uses a tolerance value to account for potential rounding errors when comparing double values.
     * 
     */
    
    private boolean greater(int i, int j) {
    	// If the difference is greater than the tolerance value, return true
        final double TOLERANCE = 0.00001;
        return _heap[i]._key - _heap[j]._key > TOLERANCE;
    }


    private void swap(int i, int j) {
        HeapNode<T> temp = _heap[i];
        _heap[i] = _heap[j];
        _heap[j] = temp;
    }
    
    public boolean isEmpty() {return _size == 0;}

    public int size() {return _size;}

}
