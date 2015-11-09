package com.operatingsystem.states;

public class SystemRunning {
	//0 for not running, 1 for running
	private boolean isRunning;
	
	public SystemRunning(){
		this.isRunning=true;
	}
	public void state_switch(){
		this.isRunning=!isRunning;
	}
	public boolean get_state(){
		return isRunning;
	}
	public void run(){
		while(isRunning){
			
		}
	}

}
