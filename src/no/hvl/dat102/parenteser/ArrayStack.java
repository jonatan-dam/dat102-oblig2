package no.hvl.dat102.parenteser;

import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T> {
	
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	} //end default constructor
	
	public ArrayStack(int initialCapacity) {
		
		checkCapacity(initialCapacity);
		
		//The cast is safe because the new array contains null entires
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	} //end constructor

	@Override
	public void push(T newEntry) {
		checkInitialization();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	} //end push

	@Override
	public T pop() {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyStackException();
		}else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	} //end pop

	@Override
	public T peek() {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyStackException();
		}else {
			return stack[topIndex];
		}
	} //end peek

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	} //end isEmpty

	@Override
	public void clear() {
		int i = -1;
		while(i < topIndex) {
			stack[i] = null;
			i++;
		}
		topIndex = -1;
	} //end clear
	
	
	/** Kaster et SecurityException om objektet ikke er intialisert skikkelig */
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException("This stack is not properly initialized");
		}
	} //end checkInitialization
	
	/** Sjekker om ønsket kapasitet er større enn tillatt maks kapasitet
	 * @param kapasitet */
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException("This surpassed max allowed capacity");
		}
	} //end checkCapacity
	
	private void ensureCapacity() {
		if (topIndex == stack.length - 1) {
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack,  newLength);
		}
	} //end EnsureCapacity

}
