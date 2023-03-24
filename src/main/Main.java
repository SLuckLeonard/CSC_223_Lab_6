package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import heap.ClassicMinHeap;
import heap.ListMinHeap;
import heap.MinHeap;
import heap.SortedListMinHeap;
import utilities.Timer;

public class Main
{
	public static void main(String[] args)
	{
		final int[] ELEMENT_COUNT = new int[] {10000, 20000, 40000, 80000, 160000, 320000, 640000, 1280000, 2560000, 5120000 };

		//
		// All heaps we are testing
		List<MinHeap<Integer>> heaps = new ArrayList<MinHeap<Integer>>();
		heaps.add(new ListMinHeap<Integer>());
		heaps.add(new SortedListMinHeap<Integer>());
		heaps.add(new ClassicMinHeap<Integer>());

		//
		// Execute the build process over all the heaps
		for (MinHeap<Integer> heap : heaps)
		{
			System.out.println(heap.getClass() + " Build Heap");
			
			List<Double> keyList = keyList(ELEMENT_COUNT[3]);
			List<Integer> valueList = valueList(ELEMENT_COUNT[3]);
			
			// create and start
			Timer timer = new Timer();
			timer.start();
			
				// operation
				heap.build(keyList, valueList);
			
			// stop
			timer.stop();
			
				// print results
				System.out.println(timer.toString());
				
			// reset and start
			timer.reset();
			timer.start();
				
				// operation
				heap.extractMin();
				
			//stop, print, reset
			timer.stop();
			System.out.println(timer.toString());
			timer.reset();
			
			//clear
			System.out.println();
			heap.clear();
		}
	}
	
	private static List<Double> keyList(int numElems)
	{
		List<Double> keys = new ArrayList<Double>();
		
		final int LOW = 0;    // included value
		final int HIGH = numElems; // included value
		
		for (int i = HIGH; i >= LOW; i--)
		{
			keys.add((double)i);
		}
		
		Collections.shuffle(keys);
		
		return keys;
	}
	
	private static List<Integer> valueList(int numElems)
	{
		List<Integer> values = new ArrayList<Integer>();
		
		final int LOW = 0;    // included value
		final int HIGH = numElems; // included value
		
		for (int i = HIGH; i >= LOW; i--)
		{
			values.add(i);
		}
		
		return values;
	}
}