package com.atul.task;

public class SequenceGenerator implements Runnable{

	private NumbersGenerator generator;
	private int result;
	
	
	public SequenceGenerator(NumbersGenerator generator, int result) {
		super();
		this.generator = generator;
		this.result = result;
	}


	@Override
	public void run() {
		generator.printNumbers(result);
	}

}
