package com.operatingsystem;

import com.operatingsystem.states.SystemGeneration;

public class execute {
	public static void main(String args[]){
		SystemGeneration generation_phase=new SystemGeneration();
		generation_phase.generate_system();
	}
}
