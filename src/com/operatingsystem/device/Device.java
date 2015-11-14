package com.operatingsystem.device;

import java.util.LinkedList;
import java.util.Queue;

import com.operatingsystem.memory.PCB;

public class Device {
	protected String device_name;
	// 0 for disk, 1 for printer
	private boolean device_type;
	// sets the device name
	private Queue<PCB> device_queue;
	private PCB current;
	public void setDeviceName(int device_number) {
		// override in child class
	}

	// gets the device name
	public String getDeviceName() {
		return device_name;
	}

	// returns the device type
	public boolean getDeviceType() {
		return device_type;
	}

	public Device(boolean type) {
		this.device_type = type;
		createDeviceQueue();
	}

	public void createDeviceQueue() {
		device_queue = new LinkedList<PCB>();
	}

	public boolean enqueue(PCB buffer) {
		if (buffer == null || device_queue == null) {
			return false;
		}
		device_queue.add(buffer);
		if(current==null){
			current=dequeue();
		}
		return true;
	}
	public PCB complete(){
		if(current==null){
			return null;
		}
		PCB tobeReturned=current;
		if(!device_queue.isEmpty()){
			current=dequeue();
		}
		else{
			current=null;
		}
		return tobeReturned;
	}
	private PCB dequeue() {
		return device_queue.remove();
	}
	public String queue_status() {
		String status = "Process that are in " + device_name + " queue are ";
		if (device_queue.isEmpty()) {
			status = " No Process in " + device_name + "'s queue";
		} else {
			for (PCB itt : device_queue) {
				status += itt.processor_id();
			}
		}
		return status;
	}
	
	public String getCurrentTaskInfo(){
		//to be overriden
		return null;
	}
}
