/**
 * A heapnode aggregator class for heap implementations. 
 *
 * @author calvin
 * @date   12-13-22
 */
 
package heap;

public class HeapNode<T> implements Comparable<HeapNode<T>>
{
	public double _key;
	public T      _value;

	public HeapNode(double key, T data)
	{
		this._value = data;
		this._key = key;
	}
	
	public String toString() { return Double.toString(_key); }

	@Override
	public int compareTo(HeapNode<T> o)
	{
		if(this._key < o._key)
			return -1;
		
		if(this._key > o._key)
			return 1;
		 
		return 0;
	}
}