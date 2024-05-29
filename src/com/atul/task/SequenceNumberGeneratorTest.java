package com.atul.task;

public class SequenceNumberGeneratorTest {

	private static final int TOTAL_NUMBER_IN_SEQUENCE = 20;
	private static final int TOTAL_NUMBER_OF_THREADS = 3;
	
	public static void main(String[] args) {
		
		NumbersGenerator generator = new NumbersGenerator(TOTAL_NUMBER_OF_THREADS, TOTAL_NUMBER_IN_SEQUENCE);
		
		Thread t1 = new Thread(new SequenceGenerator(generator, 1),"Thread -1");
		Thread t2 = new Thread(new SequenceGenerator(generator, 2),"Thread -2");
		Thread t3 = new Thread(new SequenceGenerator(generator, 0),"Thread -3");
		t1.start();
		t2.start();
		t3.start();
	}
	
}
