package com.datastructures.linkedlist;

import java.util.EmptyStackException;
import java.util.stream.Stream;

public class SinglyLinkedListWithTail<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void clear() {
		head = tail = null;
		size = 0;
	}
	
	public void addFirst(final E element) {
		head = new Node<>(element, head);
		if(tail == null) {
			tail = head.getNext();
		}
		size++;
	}
	
	public void addLast(final E element) {
		if(isEmpty()) {
			addFirst(element);
			return;
		}
		if(tail == null) {
			tail = head.getNext();
		} else {
			tail.setNext(new Node<>(element, null));
			tail = tail.getNext();
		}
		size++;
	}
	
	public void printAll() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		Stream.iterate(head, Node::getNext)
		      .limit(size)
		      .map(Node::getElement)
		      .forEach(System.out::println);
	}
	
	public E getFirst() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return head.getElement();
	}
	
	public E getLast() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return tail.getElement();
	}
	
	
	private static final class Node<E> {
		private E element;
		private Node<E> next;

		private Node(final E element, final Node<E> next) {
			this.element = element;
			this.next = next;
		}

		private E getElement() {
			return element;
		}

		private void setElement(E element) {
			this.element = element;
		}

		private Node<E> getNext() {
			return next;
		}

		private void setNext(Node<E> next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			return element.toString();
		}
	}

}
