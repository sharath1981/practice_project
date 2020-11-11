package com.useful.programmes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerArrayBlockingQueue {
	
	private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {
		
		final Thread producer1 = new Thread(ProducerConsumerArrayBlockingQueue::produce);
		final Thread producer2 = new Thread(ProducerConsumerArrayBlockingQueue::produce);
		final Thread producer3 = new Thread(ProducerConsumerArrayBlockingQueue::produce);
		final Thread consumer1 = new Thread(ProducerConsumerArrayBlockingQueue::consume);
		final Thread consumer2 = new Thread(ProducerConsumerArrayBlockingQueue::consume);
		final Thread consumer3 = new Thread(ProducerConsumerArrayBlockingQueue::consume);
		producer1.start();
		consumer1.start();
		producer2.start();
		consumer2.start();
		producer3.start();
		consumer3.start();
		
	}
	
	private static void produce() {
		for(int i=0;; i++) {
			try {
				//System.out.println("Produced => "+i);
				queue.put(i);
				System.out.println("Queue Size => "+queue.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void consume() {
		while(true) {
			try {
				queue.take();
				System.out.println("Queue Size => "+queue.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}