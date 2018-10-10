import java.util.*; 

public class MedianRunningArray {

	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(20);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(20, new MaxHeapComparator());
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 0 to end the stream....");
		System.out.println("Enter No.:- ");
		int num = sc.nextInt();

		while(num != 0) {
			if(maxHeap.peek() == null && minHeap.peek() == null) {
				minHeap.add(num);
			}else{
				add(minHeap, maxHeap, num);
			}
			if(Math.abs(minHeap.size() - maxHeap.size()) == 2) {
				balance(minHeap, maxHeap);
			}
			if(minHeap.size() - maxHeap.size() == 0) {
				System.out.println("Median :-" + (minHeap.peek() + maxHeap.peek()) / 2);
			}else{
				if(minHeap.size() > maxHeap.size())
					System.out.println("Median :-" + minHeap.peek());
				else
					System.out.println("Median :-" + maxHeap.peek());
			}
			System.out.println("Enter No.:- ");
			num = sc.nextInt();
		}
	}

	public static void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}else{
			minHeap.add(maxHeap.poll());
		}
	}

	public static void add(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int num) {
		if(maxHeap.peek() != null && maxHeap.peek() >= num) {
			maxHeap.add(num);
		}else{
			minHeap.add(num);
		}
	}
}

class MaxHeapComparator implements Comparator<Integer> {
	public int compare(Integer i1, Integer i2) {
		return -1 * i1.compareTo(i2);
	}
} 