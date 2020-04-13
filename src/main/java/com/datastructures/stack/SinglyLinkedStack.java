package com.datastructures.stack;

import java.util.EmptyStackException;
import java.util.stream.Stream;

public class SinglyLinkedStack<E> {
	private Node<E> top;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void clear() {
		top = null;
		size = 0;
	}
	
	public void push(final E element) {
		top = new Node<>(element, top);
		size++;
	}
	
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getElement();
	}
	
	public E pop() {
		final E element = peek();
		top = top.getNext();
		size--;
		return element;
	}
	
	public boolean contains(final E element) {
		return Stream.iterate(top, Node::getNext).limit(size).map(Node::getElement).anyMatch(e->e.equals(element));
	}
	
	public void printAll() {
		Stream.iterate(top, Node::getNext).limit(size).forEach(System.out::println);
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
