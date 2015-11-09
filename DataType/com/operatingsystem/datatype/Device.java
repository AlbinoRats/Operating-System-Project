package com.operatingsystem.datatype;
// Interface to Disks
public interface Device<Type> {
	
	//sets the total amount of device
	public abstract void setTotalDevice(int amount); 
	//gets the device array
	public abstract Type [] getDeviceArray();
	//gets the size of device array
	public abstract int getDeviceSize();
}
