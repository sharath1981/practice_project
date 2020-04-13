package com.datastructures.linkedlist;

import java.util.stream.Stream;

public class SinglyLinkedList<E> {
	private Node<E> head;
	private int size;

	public void addToFront(final E element) {
		head = new Node<>(element, head);
		size++;
	}

	public void addToBack(final E element) {
		if (isEmpty()) {
			addToFront(element);
			return;
		}
		
		Node<E> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(new Node<>(element));
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
			throw new IllegalStateException("Empty Linkedlist...");
		}
		return head.getElement();
	}

	public E getLast() {
		if (isEmpty()) {
			throw new IllegalStateException("Empty Linkedlist...");
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
		return Stream.iterate(head, Node::getNext)
				     .skip(index)
				     .map(Node::getElement)
				     .findFirst()
				     .orElseThrow(IndexOutOfBoundsException::new);
	}

	public void remove(final E element) {
		if (isEmpty()) {
			return;
		}
		
		if (head.getElement().equals(element)) {
			head = head.getNext();
			size--;
			return;
		}

		/*
		 * Node<E> current = head; 
		 * while (current.getNext() != null) { 
		 * 		  if (current.getNext().getElement().equals(element)) {
		 * 			  current.setNext(current.getNext().getNext()); return; 
		 *        } 
		 *        current = current.getNext(); 
		 * }
		 */

		for (Node<E> current = head; current.getNext() != null; current = current.getNext()) {
			if (current.getNext().getElement().equals(element)) {
				current.setNext(current.getNext().getNext());
				size--;
				return;
			}
		}
	}
	
	public void printAll() {
		/*
		 * Node<E> current = head; 
		 * while(current != null) { 
		 * 	     System.out.println(current);
		 * 	     current = current.getNext() 
		 * }
		 */
		
		/*
		 * for (Node<E> current = head; current != null; current = current.getNext()) {
		 * 	    System.out.println(current); 
		 * }
		 */
		
		/*
		 * Stream.iterate(head, current->current.getNext()) 
		 *       .limit(size)
		 * 		 .forEach(System.out::println);
		 */
		
		Stream.iterate(head, Node::getNext)
			  .limit(size)
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
