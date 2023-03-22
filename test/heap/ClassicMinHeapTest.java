/**
 * 
 */
package heap;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author calvin
 */
class ClassicMinHeapTest extends MinHeapTest
{
	@Test
	void test_extractMin()
	{
		MinHeap<Integer> heap = new ClassicMinHeap<Integer>();

		extractMinSortedTest(heap);
		
		heap = new ClassicMinHeap<Integer>();
		
		extractMinShuffledTest(heap);
		
		heap = new ClassicMinHeap<Integer>();

		extractMinReverseTest(heap);
	}
	
	@Test
	void testExtractMin() {
		
		MinHeap<Integer> heap = new ClassicMinHeap<Integer>();
		
		heap.build(new ArrayList<Double>(Arrays.asList(1.0)), new ArrayList<Integer>(Arrays.asList(1)));
		
		assertEquals(1.0, heap.extractMin()._key);
		
		heap.insert(0.5, 7);
		
		assertEquals(0.5, heap.extractMin()._key);
	}
}
