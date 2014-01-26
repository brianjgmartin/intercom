package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedCapacityMinHeap<T extends Comparable<T>> {
	List<T> heap = new ArrayList<T>();
	boolean isFixedSized = false;
	int capacity = -1;

	public FixedCapacityMinHeap() {
	}

	public FixedCapacityMinHeap(Integer capacity, boolean isFixedSize) {
		this.capacity = capacity;
		this.isFixedSized = isFixedSize;
	}

	/**
	 * Add element in heap <br>
	 * If isFixedSized enabled this method will checks if addition of new
	 * element increase the heap size then compare the new element with root
	 * element and if new element is greater then root will replace the
	 * root.value with element.value and reformat the heap
	 * 
	 * @param elem
	 *            - element to be added to heap
	 */
	public void add(T elem) {
		if (isFixedSized) {
			if (heap.size() < capacity) {
				addElement(elem);
			} else {
				// New element will increase the heap size
				T minValue = min();
				if (minValue != null) {
					if (elem.compareTo(minValue) >= 0) {
						// elem is greater then minimum element of heap,
						// need to be replaced with root and heap need to
						// heapify
						heap.set(0, elem);
						heapify();
					}
				}

			}
		} else {
			addElement(elem);
		}
	}

	/**
	 * This method takes root element and percolate is down to satisfy min-heap
	 * property.
	 */
	private void heapify() {
		if (heap.isEmpty()) {
			return;
		}
		T parent = heap.get(0);
		int k = 1;
		int size = heap.size();
		int leftChild = 2 * k;
		int rightChild = 2 * k + 1;

		while (leftChild < size || rightChild < size) {
			int minChild = -1;

			if (leftChild <= size && rightChild <= size) {
				// both child exist
				minChild = heap.get(leftChild - 1).compareTo(
						heap.get(rightChild - 1)) < 0 ? leftChild : rightChild;
			} else if (leftChild <= size) {
				// only left child exist
				minChild = leftChild;
			} else if (rightChild <= size) {
				// only right child exist
				minChild = rightChild;
			}
			if (minChild == -1 || parent.compareTo(heap.get(minChild - 1)) < 0) {
				return;
			}

			T minValue = heap.get(minChild - 1);
			heap.set(k - 1, minValue);
			k = minChild;
			leftChild = 2 * k;
			rightChild = 2 * k + 1;
		}
		heap.set(k - 1, parent);
	}

	/**
	 * Returns top element of heap if heap is not empty. Else returns null;
	 * 
	 * @return - top element of heap or null
	 */
	public T min() {
		if (heap.isEmpty())
			return null;
		return heap.get(0);

	}

	/**
	 * Given an element this method will find and insert the element at correct
	 * index at which it should be inserted without voilating min-heap property
	 * 
	 * @param elem
	 *            - element to be inserted in heap
	 */
	private void addElement(T elem) {
		heap.add(null); // adding a new element as null then finding its proper
						// location in heap
		int k = heap.size() - 1;
		int parent;
		while (k > 0) {
			parent = (k) / 2;
			T parentValue = heap.get(parent);
			if (elem.compareTo(parentValue) >= 0) {
				// Means element is greater then (or equal to) parentValue
				// No need to percolate up since its a min-heap
				break;
			}
			heap.set(k, parentValue); // moving parent node down as new element
										// is smaller
			k = parent;
		}
		heap.set(k, elem);
	}

	public void print() {
		Object[] array = heap.toArray();
		Arrays.sort(array);
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
	}
}
