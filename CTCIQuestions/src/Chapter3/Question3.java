package Chapter3;

import java.util.ArrayList;
import java.util.List;
import DataStructures.*;

public class Question3<T>{

	private List<Stack<T>> stacks;
	private final int threshold;
	private int size;
	private int currentStackIndex;

	public Question3(int threshold){
		this.stacks = new ArrayList<Stack<T>>();
		this.stacks.add(new Stack<T>());
		this.threshold = threshold > 0 ? threshold : 1;
		this.size = 0;
		this.currentStackIndex = 0;
	}
	
	public boolean empty(){
		return this.size == 0;
	}
	
	public boolean full(){
		return this.size == this.stacks.size() * this.threshold;
	}
	
	public T peek(){
		if(this.empty()){
			return null;
		}
		return this.stacks.get(this.currentStackIndex).peek();
	}
	
	/**
	 * TODO: need to add popAt(index) functionality
	 */
	
	public T pop(){
		if(this.empty()){
			return null;
		}
		T val = this.stacks.get(this.currentStackIndex).pop();
		while(val == null && this.currentStackIndex >= 0){
			this.stacks.remove(this.currentStackIndex);
			this.currentStackIndex--;
			val = this.stacks.get(this.currentStackIndex).pop();
		}
		if(val != null){
			this.size--;
		}
		
		return val;
	}
	
	public T push(T item){
		if(item == null){
			return null;
		}
		
		if(this.stacks.get(this.currentStackIndex).size() < this.threshold){
			this.stacks.get(this.currentStackIndex).push(item);
		}else{
			this.stacks.add(new Stack<T>());
			this.currentStackIndex++;
			this.stacks.get(this.currentStackIndex).push(item);
		}
		this.size++;
		
		return item;
	}
	
	public int size(){
		return this.size;
	}
}
