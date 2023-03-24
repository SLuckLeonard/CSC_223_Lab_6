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
		MinHeap<Integer> heap = new ListMinHeap<Integer>();

		extractMinSortedTest(heap);
		
		heap = new ListMinHeap<Integer>();
		
		extractMinShuffledTest(heap);
		
		heap = new ListMinHeap<Integer>();

		extractMinReverseTest(heap);
	}
	
	
}
