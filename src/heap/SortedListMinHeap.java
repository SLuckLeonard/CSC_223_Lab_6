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
        for (int i = 0; i < _size; i++) {
            _heap[i] = new HeapNode<>(keys.get(i), values.get(i));
        }
        Arrays.sort(_heap);
    }

    @Override
    public void insert(double key, T value) {
        int index = _size;
        HeapNode<T> node = new HeapNode<>(key, value);
        while (index > 0 && node.compareTo(_heap[index - 1]) < 0) {
            _heap[index] = _heap[index - 1];
            index--;
        }
        _heap[index] = node;
        _size++;
    }

    @Override
    public HeapNode<T> extractMin() {
        if (isEmpty()) {
            return null;
        }
        HeapNode<T> minNode = _heap[0];
        for (int i = 1; i < _size; i++) {
            _heap[i - 1] = _heap[i];
        }
        _size--;
        return minNode;
    }

    @Override
    public HeapNode<T> peekMin() {
        if (isEmpty()) {
            return null;
        }
        return _heap[0];
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public void clear() {
        init(_heap.length);
    }

}
