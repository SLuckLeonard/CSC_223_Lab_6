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
		heaps.add(new ClassicMinHeap<Integer>());
		heaps.add(new SortedListMinHeap<Integer>());
		heaps.add(new ListMinHeap<Integer>());

		//
		// Execute the build process over all the heaps
		for (MinHeap<Integer> heap : heaps)
		{
			
			for(int i : ELEMENT_COUNT){
				
				System.out.println(heap.getClass() + "Size " + i 
													+ " Build Heap");
				// helloi
				List<Double> keyList = keyList(i);
				List<Integer> valueList = valueList(i);
				
				Timer timer = new Timer();
				timer.start();
				
				heap.build(keyList, valueList);
				
				timer.stop();
				System.out.println(timer.toString());
				timer.reset();
				
				System.out.println("Starting extractMin Timer");
				timer.start();
				heap.extractMin();
				timer.stop();
				System.out.println(timer.toString());
				timer.reset();
				
				System.out.println();
				heap.clear();
				
			}
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
		
		Collections.shuffle(values);
		
		return values;
	}
}