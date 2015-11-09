package com.operatingsystem.device;
// Interface to Disks
public class Device {
	String device_name;
	boolean device_type;
	//sets the device name
	public  void setPrinterName(String name){
		this.device_name=name;
	}
	//gets the device name
	public String getPrinterName(){
		return device_name;
	}
	//returns the device type
	public boolean getDeviceType(){
		return device_type;
	}
	public Device(boolean type){
		this.device_type=type;
	}
	
}
