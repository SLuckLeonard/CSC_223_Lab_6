package heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ClassicMinHeap<T> implements MinHeap<T>
{
	protected HeapNode<T>[] _heap;
    protected int           _size;
    @Override
    public void build(List<Double> keys, List<T> values) {
      
    	init(keys.size());
    	
    	_heap[1] = makeNode(keys.get(0), values.get(0));

    }

    @SuppressWarnings("unchecked")
	private void init(int size) {
    	
    	 _heap =  new HeapNode[size];
    	 
    }
    @Override
    public void insert(double key, T value) {
        
    	_heap[_size + 1] = new HeapNode<T>(key, value);
    	
    	_size++;
    	
    	swim(_size);

    }
    @Override
    public HeapNode<T> extractMin() {
        // TODO Auto-generated method stub

        if(!isEmpty()) return null;

    	HeapNode<T> min = _heap[_size];
       
    	swap(1, _size);
   
        
        sink(1);
        
        _heap[_size] = null;

        return min;
    }
    
    private void swap(int i, int j) {
    	
    	HeapNode<T> temp = _heap[i];
    	
    	_heap[i] = _heap[j];
    	
    	_heap[j] = temp;
    	
    }
    
    private HeapNode<T> makeNode(double key, T value) {
    	
    	return new HeapNode<T>(key, value);
    }
    @Override
    public HeapNode<T> peekMin() {
        
        if(!isEmpty()) return _heap[1];

        return null;
    }
    @Override
    public boolean isEmpty() {
        return _size == 0;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return _size;
    }
    @Override
    public void clear() {

    	_size = 0;
    	
        init(0);

    }
    
    private int smaller(int l, int r){
    	
    	if(_heap[l].compareTo(_heap[r]) < 0) return l;
    	
    	if(_heap[l].compareTo(_heap[r]) > 0) return r;
    	
    	return l;
    }

    private void sink(int i) {
    	
    	int index = i;
    	
        while(left(index) != -1) {
        	
        	// get the smaller of the child nodes
        	int smaller = smaller(left(index), right(index));
        	
        	if(_heap[smaller].compareTo(_heap[index]) > 0) break;
        	
        	swap(index, smaller);
        	
        	index = smaller;
        	
        }
    }
    
    private void swim(int i) {
    	
    	while (i > 1 && _heap[i].compareTo(_heap[parent(i)]) < 0) {
    		
    		swap(i, parent(i));
    		
    	}
    }
    
    private int parent(int i) {
    	
    	if(i % 2 == 0) return i / 2;
    	
    	return (i - 1) / 2;
    }

    private int left (int l) { 

    	if(_size >= l * 2) return l * 2; 

        return -1;}

    private int right(int r){ 

    	if(_size >= (r * 2) + 1) return  (r * 2) + 1; 

        return -1;}

}