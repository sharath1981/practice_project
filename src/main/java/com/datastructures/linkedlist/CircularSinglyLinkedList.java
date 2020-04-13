package com.datastructures.linkedlist;

import java.util.EmptyStackException;
import java.util.stream.Stream;

public class CircularSinglyLinkedList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		first = last = null;
		size = 0;
	}
	
	public void addFirst(final E element) {
		first = new Node<>(element, first);
		if(isEmpty()) {
			last = first;
		} 
		last.setNext(first);
		size++;
	}
	
	public void addLast(final E element) {
		if(isEmpty()) {
			addFirst(element);
			return;
		}
		last = new Node<>(element, first);
		size++;
	}
	
	public E getFirst() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return first.getElement();
	}
	
	public E getLast() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return last.getElement();
	}
	
	public void printAll() {
		Stream.iterate(first, Node::getNext)
		      .limit(size)
		      .map(Node::getElement)
		      .forEach(System.out::println);
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
