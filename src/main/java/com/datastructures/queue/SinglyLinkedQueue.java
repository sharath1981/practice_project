package com.datastructures.queue;

import java.util.EmptyStackException;
import java.util.stream.Stream;

public class SinglyLinkedQueue<E> {
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
		final Node<E> newNode = new Node<>(element);
		size++;
		if(isEmpty()) {
			first = last = newNode;
			return;
		}
		last.setNext(newNode);
		last = newNode;
	}
	
	public E dequeue() {
		final E element = getFirst();
		first  = first.getNext();
		size--;
		return element;
	}
	
	public E getFirst() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return first.getElement();
	}
	
	public void printAll() {
		Stream.iterate(first, Node::getNext)
			  .limit(size)
			  .map(Node::getElement)
			  .forEach(e->System.out.print(e+" <= "));
	}
	
	private static final class Node<E> {
		private Node<E> next;
		private final E element;

		public Node(final E element) {
			this.element = element;
		}
		
		public Node(final E element, final Node<E> next) {
			this(element);
			this.next = next;
		}

		private Node<E> getNext() {
			return next;
		}

		private void setNext(Node<E> next) {
			this.next = next;
		}

		private E getElement() {
			return element;
		}

		public String toString() {
			return element.toString();
		}
	}
}
