package com.datastructures.linkedlist;

import java.util.EmptyStackException;
import java.util.stream.Stream;

public class CircularDoublyLinkedList<E> {
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
	
	public void addFirst(final E element) {
		first = new Node<>(first, element);
		size++;
		if(isEmpty()) {
			last = first;
			return;
		}
		first.getNext().setPrev(first);
		last.setNext(first);
	}
	
	public void addLast(final E element) {
		last = new Node<>(element, last);
		size++;
		if(isEmpty()) {
			first = last;
			return;
		}
		last.getPrev().setNext(last);
		first.setPrev(last);
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
	
	public void printForward() {
		Stream.iterate(first, Node::getNext)
			  .limit(size)
			  .map(Node::getElement)
			  .forEach(System.out::println);
	}
	
	public void printBackward() {
		Stream.iterate(last, Node::getPrev)
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

		public Node(final Node<E> first, final E element) {
			this(element);
			next = first;
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
