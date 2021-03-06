//: innerclass/Sequence.java
// Holds a sequence of Objects

package com.innerclasses10;

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	
	private Object[] items;
	private int next = 0;
	Sequence(int size) {
		items = new Object[size];
	}
	public void add(Object x) {
		if(next < items.length) {
			items[next++] = x;
		}
	}
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++;}
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.println(selector.current() + " ");
			selector.next();
		}
	}

}
