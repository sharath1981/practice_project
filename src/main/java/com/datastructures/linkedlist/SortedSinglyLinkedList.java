package com.datastructures.linkedlist;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class SortedSinglyLinkedList<E extends Comparable<E>> {
	private Node<E> head;
	private int size;

	public void add(final E element) {
		if (isEmpty() || head.getElement().compareTo(element) > 0) {
			addToFront(element);
			return;
		}
		Node<E> current = head;
		Node<E> previous = null;
		while (current != null && current.getElement().compareTo(element) <= 0) {
			previous = current;
			current = current.getNext();
		}
		if (previous != null) {
			previous.setNext(new Node<>(element, current));
		}
		size++;
	}

	private void addToFront(final E element) {
		head = new Node<>(element, head);
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public E getFirst() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return head.getElement();
	}

	public E getLast() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Node<E> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current.getElement();
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public E elementAt(final int index) {
		return Stream.iterate(head, Node::getNext).skip(index).map(Node::getElement).findFirst()
				.orElseThrow(IndexOutOfBoundsException::new);
	}

	public void remove(final E element) {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		if (head.getElement().equals(element)) {
			head = head.getNext();
			size--;
			return;
		}
		for (Node<E> current = head; current.getNext() != null; current = current.getNext()) {
			if (current.getNext().getElement().equals(element)) {
				current.setNext(current.getNext().getNext());
				size--;
				return;
			}
		}
		throw new NoSuchElementException();
	}

	public void printAll() {
		Stream.iterate(head, Node::getNext).limit(size).forEach(System.out::println);
	}

	private static final class Node<E extends Comparable<E>> {
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
