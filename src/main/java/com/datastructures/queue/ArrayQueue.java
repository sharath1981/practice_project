/**
 * 
 */
package com.datastructures.queue;

import java.util.Arrays;

/**
 * @author Sharath Kumar B <sharath1981@gmail.com>
 *
 */
public class ArrayQueue<E> {

	private E[] queue;
	private int index;

	public ArrayQueue(final int capacity) {
		queue = (E[]) new Object[capacity];
		index = -1;
	}

	public int size() {
		return index + 1;
	}

	public boolean isEmpty() {
		return index == -1;
	}

	private boolean isFull() {
		return size() == queue.length;
	}

	public void enQueue(final E element) {
		reSize();
		queue[++index] = element;
	}

	private void reSize() {
		if (isFull()) {
			final E[] temp = (E[]) new Object[queue.length * 2];
			System.arraycopy(queue, 0, temp, 0, queue.length);
			queue = temp;
		}
	}

	public E deQueue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue Underflow...");
		}
		final E element = queue[0];
		System.arraycopy(queue, 1, queue, 0, queue.length - 1);
		queue[index--] = null;
		return element;
	}

	public boolean contains(final E element) {
		return Arrays.stream(queue).anyMatch(e -> e.equals(element));
	}

	public void printAll() {
		System.out.println(Arrays.toString(queue));
	}
}
