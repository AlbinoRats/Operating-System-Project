package com.operatingsystem.memory;

import java.util.ArrayList;

public class Memory {
	// false means memory space is empty, true means it's being used
	private Boolean [] memory;
	public Memory(int memory_size){
		this.memory=new Boolean[memory_size];
		for(Boolean itt:memory){
			itt=false;
		}
	}
	
	
}
