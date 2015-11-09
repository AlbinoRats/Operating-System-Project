package com.operatingsystem;

import com.operatingsystem.states.SystemGeneration;
import com.operatingsystem.states.SystemRunning;

public class execute {
	public static void main(String args[]){
		SystemGeneration generation_phase=new SystemGeneration();
		generation_phase.generate_system();
		SystemRunning running_phase=new SystemRunning();
		running_phase.run();
	}
}
