package com.datastructures.queue;

import java.util.EmptyStackException;
import java.util.stream.Stream;

public class DoublyLinkedQueue<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return first == null || last == null;
	}
	
	public void clear() {
		first = last = null;
		size = 0;
	}
	
	public void enqueue(final E element) {
		last = new Node<>(element, last);
		size++;
		if (isEmpty()) {
			first = last;
			return;
		}
		last.getPrev().setNext(last);
	}
	
	public E dequeue() {
		final E element = getFirst();
		first = first.getNext();
		first.setPrev(null);
		size--;
		return element;
	}

	public E getFirst() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return first.getElement();
	}
	
	public void printAll() {
		Stream.iterate(first, Node::getNext)
			  .limit(size)
			  .map(Node::getElement)
			  .forEach(System.out::println);
	}
	
	private static final class Node<E> {
		private Node<E> next;
		private Node<E> prev;
		private final E element;

		public Node(final E element) {
			this.element = element;
		}

		public Node(final E element, final Node<E> last) {
			this(element);
			prev = last;
		}

		private Node<E> getNext() {
			return next;
		}

		private void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		private E getElement() {
			return element;
		}

		public String toString() {
			return element.toString();
		}
	}
}
