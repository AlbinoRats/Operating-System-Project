package com.operatingsystem.memory;

public class MemoryBlock {
	private int size;
	private int processor_id;
	private boolean being_used;
	private int processor_size;
	private int left_over;
	public MemoryBlock(){
		
	}
	public void set_size(int size){
		this.size=size;
	}
	public void set_id(int processor_id){
		this.processor_id=processor_id;
	}
	public void switchUsed(){
		this.being_used=!being_used;
	}
	public boolean get_used(){
		return being_used;
	}
	public int get_size(){
		return size;
	}
	public int processor_id(){
		return processor_id;
	}

}
