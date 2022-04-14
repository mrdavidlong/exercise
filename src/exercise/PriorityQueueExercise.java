package exercise;

import java.util.*;

class HeapNode implements Comparable<HeapNode>{
	public int rank;
	
	HeapNode(int rank) {
		this.rank = rank;
	}
	
	public int compareTo(HeapNode compareNode) {
		 return compareNode.rank - this.rank;
	}
	
	public static Comparator<HeapNode> RankComparator 
    	= new Comparator<HeapNode>() {

		public int compare(HeapNode o1, HeapNode o2) {	
			if (o1.rank < o2.rank) return 1;
			else if (o1.rank == o2.rank) return 0;
			else return -1;
		}
	};
}


public class PriorityQueueExercise {
	private static Comparator<Integer> maxHeapComparator;
	private static Comparator<Integer> minHeapComparator;
	private static PriorityQueue<Integer> maxHeap;
	private static PriorityQueue<Integer> minHeap;

	public static void addNewNumber(int randomNumber) {
		/* Note: addNewNumber maintains a condition that maxHeap.size() >= minHeap.size() */
		if (maxHeap.size() == minHeap.size()) {
			if ((minHeap.peek() != null) && 
					randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		}
		else {
			if(randomNumber < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			}
			else {
				minHeap.offer(randomNumber);
			}
		}
	}

	public static double getMedian() {
		/* maxHeap is always at least as big as minHeap. So if maxHeap is empty, then minHeap is also. */		
		if (maxHeap.isEmpty()) {
			return 0;
		} 
		if (maxHeap.size() == minHeap.size()) {
			return ((double)minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else {
			/* If maxHeap and minHeap are of different sizes, then maxHeap must have one extra element. Return maxHeap�s top element.*/			
			return maxHeap.peek();
		} 
	}

	public static void addNewNumberAndPrintMedian(int randomNumber) {
		addNewNumber(randomNumber);
		System.out.println("Random Number = " + randomNumber);
		printMinHeapAndMaxHeap();
		System.out.println("\nMedian = " + getMedian() + "\n");
	}

	public static void printMinHeapAndMaxHeap(){
		Integer[] minHeapArray = minHeap.toArray(
				new Integer[minHeap.size()]);
		Integer[] maxHeapArray = maxHeap.toArray(
				new Integer[maxHeap.size()]);

		Arrays.sort(minHeapArray, maxHeapComparator);
		Arrays.sort(maxHeapArray, maxHeapComparator);
		System.out.print("MinHeap =");
		for (int i = minHeapArray.length - 1; i >= 0 ; i--){
			System.out.print(" " + minHeapArray[i]);
		}
		System.out.print("\nMaxHeap =");
		for (int i = 0; i < maxHeapArray.length; i++){
			System.out.print(" " + maxHeapArray[i]);
		}
	}

	public static void Method1(Integer i) {
		i++;
	}
	
	public static void printIntegers(Iterable<Integer> list) {
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args) {

		String s = new String("abc");
		String s2 = new String("abc");
		boolean b = s == s2;
		
		String s3 = "abc";
		String s4 = "abc";
		boolean b2 = s3 == s4;

		/////////////  Heap with Integers ///////////
		Integer[] a = {3,1,6,2,7};
		maxHeapComparator = new MaxHeapComparator();
		maxHeap = new PriorityQueue<Integer>(a.length, maxHeapComparator);
		for (Integer num : a) {
			maxHeap.offer(num);
		}
		Integer[] maxHeapArray = maxHeap.toArray(new Integer[maxHeap.size()]);
		Arrays.sort(maxHeapArray, maxHeapComparator);
		for (Integer num : maxHeapArray) {
			System.out.println(num);
		}

		while (!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll());
		}
		
		///////////////  Heap with Node ///////////
		PriorityQueue<HeapNode> maxHeap2 = new PriorityQueue<HeapNode>(100, HeapNode.RankComparator);
		for (int i = 0; i < 10; i++) {
			maxHeap2.offer(new HeapNode(i));
		}
		
		for (int i = 0; i < 10; i++) {
			HeapNode n = maxHeap2.poll();
			System.out.println(n.rank);
		}	
		
		//Arrays.sort(a, minHeapComparator);
		System.out.println(a);
		
		
		
//		for(int i = 0; i < arraySize; i++) {
//			int randomNumber = (int) (Math.random( ) * (range+1));
//			addNewNumberAndPrintMedian(randomNumber);
//		}
	}
}
