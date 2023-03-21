package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author calvin
 */
class ListMinHeapTest extends MinHeapTest
{
	@Test
	void test_extractMin()
	{
//		MinHeap<Integer> heap = new ListMinHeap<Integer>();
//
//		extractMinSortedTest(heap);
//		
//		heap = new ListMinHeap<Integer>();
//		
//		extractMinShuffledTest(heap);
//		
//		heap = new ListMinHeap<Integer>();
//
//		extractMinReverseTest(heap);
	}
	
	@Test
	void test_construction()
	{
		MinHeap<String> heap = new ListMinHeap<String>();
		assertTrue(heap.isEmpty());
		assertEquals(0, heap.size());
		
		heap.build(Arrays.asList(1.0, 2.5, 3.9), Arrays.asList("List", "Min", "Heap"));
		
		assertFalse(heap.isEmpty());
		assertEquals(3, heap.size());
		
		assertEquals("(1.0, List, 2.5, Min, 3.9, Heap)", 
				heap.toString());
		
		heap.insert(0.1, "its working");
		heap.insert(0.2, "lfg");
		
		assertEquals("(1.0, List, 2.5, Min, 3.9, Heap, 0.1, its working, 0.2, lfg)", 
				heap.toString());
		
		assertEquals("0.1", heap.peekMin().toString());
		
		assertEquals("0.1", heap.extractMin().toString());
		
		assertEquals("(1.0, List, 2.5, Min, 3.9, Heap, 0.2, lfg)",
				heap.toString());
		
		heap.extractMin();
		System.out.println(heap.toString());
		heap.extractMin();
		System.out.println(heap.toString());
		heap.extractMin();
		System.out.println(heap.toString());
		heap.extractMin();
		System.out.println(heap.toString());
		heap.extractMin();
		System.out.println(heap.toString());
		heap.extractMin();
		System.out.println(heap.toString());

//		heap.clear();
//		
//		assertEquals("()", heap.toString());
//		assertTrue(heap.isEmpty());
//		assertEquals(0, heap.size());
	}

}
