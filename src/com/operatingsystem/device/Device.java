package com.operatingsystem.device;

import java.util.LinkedList;
import java.util.Queue;

public class Device {
	protected String device_name;
	//0 for disk, 1 for printer
	private boolean device_type;
	//sets the device name
	private Queue<Device> device_queue;
	public  void setDeviceName(int device_number){
		//override in child class
	}
	//gets the device name
	public String getDeviceName(){
		return device_name;
	}
	//returns the device type
	public boolean getDeviceType(){
		return device_type;
	}
	public Device(boolean type){
		this.device_type=type;
	}
	public void createDeviceQueue(){
		device_queue=new LinkedList<Device>();
	}
}
