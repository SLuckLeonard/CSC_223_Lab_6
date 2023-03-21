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
        // TODO Auto-generated method stub

    }

    private void init(int size) {
    	
    	 _heap =  new HeapNode[size];
    	 //alkjsdfkksfkaljfdsakj
    	 
    }
    @Override
    public void insert(double key, T value) {
        // TODO Auto-generated method stub

    }
    @Override
    public HeapNode<T> extractMin() {
        // TODO Auto-generated method stub

        //if(_heap.isEmpty()) return null;

        HeapNode<T> min = _heap[1];

        HeapNode<T> last = _heap[_size - 1];

        //_heap.set(1, last);

        //sink(_heap.get(1));

        return min;
    }
    @Override
    public HeapNode<T> peekMin() {
        // TODO Auto-generated method stub
        //if(!_heap.isEmpty()) return _heap[1];

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

        //_heap.clear();

    }

    private void sink(HeapNode<T> node) {

        // ask if its better to manipulate the keys and values or the nodes themselves
    }

    private HeapNode<T> left (HeapNode<T> node) { 

//        int index = _heap.indexOf(node) * 2;
//
//        if(index < _heap.size()) {
//
//            return _heap.get(index); 
//        }

        return null;}

    private HeapNode<T> right(HeapNode<T> node){ 

//        int index = (_heap.indexOf(node) * 2) + 1;
//
//        if(index < _heap.size()) {
//
//            return _heap.get(index); 
//        }

        return null;}

    //
    // TODO
    //
}