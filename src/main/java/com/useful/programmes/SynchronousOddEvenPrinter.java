package com.useful.programmes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousOddEvenPrinter {
	private static volatile boolean toggle;
	private static volatile int number = 1;
	private static AtomicInteger atm = new AtomicInteger();
	private static AtomicBoolean flipFlop = new AtomicBoolean();

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		try {
			service.execute(SynchronousOddEvenPrinter::odd1);
			service.execute(SynchronousOddEvenPrinter::even1);
		} finally {
			service.shutdown();
		}
	}

	private synchronized static void odd() {
		while (true) {
			if (toggle) {
				try {
					SynchronousOddEvenPrinter.class.wait();
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("odd=>" + number++);
			toggle = !toggle;
			SynchronousOddEvenPrinter.class.notifyAll();
		}
	}

	private synchronized static void even() {
		while (true) {
			if (!toggle) {
				try {
					SynchronousOddEvenPrinter.class.wait();
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("even=>" + number++);
			toggle = !toggle;
			SynchronousOddEvenPrinter.class.notifyAll();
		}
	}

	private static void odd1() {
		synchronized (SynchronousOddEvenPrinter.class) {
			while (true) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
					if (atm.get() % 2 == 0) {
						SynchronousOddEvenPrinter.class.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("odd=>" + atm.getAndIncrement());
				SynchronousOddEvenPrinter.class.notify();
			}
		}
	}

	private static void even1() {
		synchronized (SynchronousOddEvenPrinter.class) {
			while (true) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
					if (atm.get() % 2 != 0) {
						SynchronousOddEvenPrinter.class.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("even=>" + atm.getAndIncrement());
				SynchronousOddEvenPrinter.class.notify();
			}
		}
	}

}