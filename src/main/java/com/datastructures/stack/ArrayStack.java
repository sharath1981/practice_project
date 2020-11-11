/**
 * 
 */
package com.datastructures.stack;

import java.util.Arrays;

/**
 * @author Sharath Kumar B <sharath1981@gmail.com>
 *
 */
public class ArrayStack<E> {

	private E[] stack;
	private int top;

	public ArrayStack(final int capacity) {
		stack = (E[]) new Object[capacity];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private boolean isFull() {
		return size() == stack.length;
	}

	public void push(final E element) {
		reSize();
		stack[++top] = element;
	}

	private void reSize() {
		if (isFull()) {
			/*
			final E[] temp = (E[]) new Object[stack.length * 2];
			System.arraycopy(stack, 0, temp, 0, stack.length);
			stack = temp;
			*/
			stack = Arrays.copyOf(stack, stack.length * 2);
		}
	}

	public E peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack Underflow...");
		}
		return stack[top];
	}

	public E pop() {
		final E element = peek();
		stack[top--] = null;
		return element;
	}

	public boolean contains(final E element) {
		return Arrays.stream(stack).anyMatch(e -> e.equals(element));
	}

	public void printAll() {
		System.out.println(Arrays.toString(stack));
	}
}
